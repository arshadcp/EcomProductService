package dev.arshad.EcomProductService.Mapper;

import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductEntityToDto {
    public static ProductResponseDTO covertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO responseDTO=new ProductResponseDTO();
           // responseDTO.setProductId(product.getId());
            responseDTO.setTitle(product.getName());
            responseDTO.setDescription(product.getDescription());
            responseDTO.setCategory(product.getCategory());
            responseDTO.setPrice(product.getPrice());
            responseDTO.setImageURL(product.getImageURL());
            responseDTO.setRating(product.getRating());


        return responseDTO;
    }
}
