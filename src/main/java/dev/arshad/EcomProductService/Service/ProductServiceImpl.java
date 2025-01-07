package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;
import dev.arshad.EcomProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID productId) throws ProductNotFoundException {
        Product savedProduct=productRepository.findById(productId).get();
        if(savedProduct==null){
            throw new ProductNotFoundException("Product not found for the given id:"+productId);
        }
        return savedProduct;
    }

    @Override
    public boolean deleteProduct(UUID productid) {

            productRepository.deleteById(productid);
            return true;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product updatedProduct, UUID productId) {
        Product savedProduct= productRepository.findById(productId).orElseThrow(
          ()->new ProductNotFoundException("Product not found with id:"+productId));

        savedProduct.setName(updatedProduct.getName());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setCategory(updatedProduct.getCategory());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct.setRating(updatedProduct.getRating());
        savedProduct.setPrice(updatedProduct.getPrice());
       savedProduct= productRepository.save(savedProduct);
       return savedProduct;

    }

    @Override
    public Product getProduct(String productName) {
        return productRepository.findBProductByName(productName);
    }

    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice,maxPrice);
    }
}
