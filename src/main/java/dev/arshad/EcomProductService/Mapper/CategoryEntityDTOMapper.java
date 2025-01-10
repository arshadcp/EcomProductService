package dev.arshad.EcomProductService.Mapper;

import dev.arshad.EcomProductService.DTO.CategoryDTO.CategoryResponseDTO;
import dev.arshad.EcomProductService.DTO.CategoryDTO.CreateCategoryRequestDTO;
import dev.arshad.EcomProductService.DTO.CreateProductRequestDTO;
import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Category;
import dev.arshad.EcomProductService.Entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryEntityDTOMapper {
    public static CategoryResponseDTO covertCategoryEntityToCategorytResponseDTO(Category category){
        CategoryResponseDTO responseDTO=new CategoryResponseDTO();

        responseDTO.setCategoryName(category.getName());
      //  responseDTO.setCategoryId(category.getId());

        List<Product> products=category.getProducts();
        List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();
        if(!(category.getProducts()==null || category.getProducts().isEmpty())){
            for(Product product:products){

                productResponseDTOS.add(ProductEntityToDtoMapper.covertProductEntityToProductResponseDTO(product));
            }
       }
        responseDTO.setProducts(productResponseDTOS);
        return responseDTO;
    }

    public static Category covertCreateCategoryRequestDTOToCategory(CreateCategoryRequestDTO categoryRequestDTO){
        Category category=new Category();
        category.setName(categoryRequestDTO.getCategoryName());
        return category;
    }


}
