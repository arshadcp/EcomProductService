package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.DTO.CreateProductRequestDTO;
import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Category;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.CategoryNotFoundException;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;
import dev.arshad.EcomProductService.Mapper.ProductEntityToDtoMapper;
import dev.arshad.EcomProductService.Repository.CategoryRepository;
import dev.arshad.EcomProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProduct() {
       List<Product> savedProducts=  productRepository.findAll();
       List<ProductResponseDTO> responseDTO= new ArrayList<>();
       for(Product product:savedProducts){
           responseDTO.add(ProductEntityToDtoMapper.covertProductEntityToProductResponseDTO(product));
       }
       return responseDTO;

    }

    @Override
    public ProductResponseDTO getProductById(UUID productId) throws ProductNotFoundException {
        Product savedProduct=productRepository.findById(productId).get();
        if(savedProduct==null){
            throw new ProductNotFoundException("Product not found for the given id:"+productId);
        }
        return ProductEntityToDtoMapper.covertProductEntityToProductResponseDTO(savedProduct);
    }



    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {

        Product product= ProductEntityToDtoMapper.covertCreateProductRequestDTOToProduct(productRequestDTO);
        Category savedCategory=categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException("Category not found for Id:"+productRequestDTO.getCategoryId()));
        product.setCategory(savedCategory);
        Product savedproduct= productRepository.save(product);



        List<Product> categoryProducts = savedCategory.getProducts();
        categoryProducts.add(savedproduct);//adding products to category
        savedCategory.setProducts(categoryProducts);
        categoryRepository.save(savedCategory);
        return ProductEntityToDtoMapper.covertProductEntityToProductResponseDTO(savedproduct);
    }
    @Override
    public boolean deleteProduct(UUID productid) {

        productRepository.deleteById(productid);
        return true;
    }


    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO createProductRequestDTO, UUID productId) {

        Product savedProduct= productRepository.findById(productId).orElseThrow(
          ()->new ProductNotFoundException("Product not found with id:"+productId));

        savedProduct.setName(createProductRequestDTO.getTitle());
        savedProduct.setDescription(createProductRequestDTO.getDescription());
       // savedProduct.setCategory(createProductRequestDTO.getCategory());
        savedProduct.setImageURL(createProductRequestDTO.getImageURL());

        savedProduct.setPrice(createProductRequestDTO.getPrice());
       savedProduct= productRepository.save(savedProduct);
       return ProductEntityToDtoMapper.covertProductEntityToProductResponseDTO(savedProduct);

    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        Product savedProduct= productRepository.findBProductByName(productName);
        return ProductEntityToDtoMapper.covertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getProducts(double minPrice, double maxPrice) {
        List<Product> savedProducts= productRepository.findByPriceBetween(minPrice,maxPrice);
        List<ProductResponseDTO> products=new ArrayList<>();
        for(Product pr:savedProducts){
            products.add(ProductEntityToDtoMapper.covertProductEntityToProductResponseDTO(pr));
        }
        return products;
    }
}
