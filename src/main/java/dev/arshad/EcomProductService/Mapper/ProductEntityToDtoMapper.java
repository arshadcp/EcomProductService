package dev.arshad.EcomProductService.Mapper;

import dev.arshad.EcomProductService.DTO.CreateProductRequestDTO;
import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEntityToDtoMapper {
    public static ProductResponseDTO covertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO responseDTO=new ProductResponseDTO();

            responseDTO.setTitle(product.getName());
            responseDTO.setDescription(product.getDescription());
            responseDTO.setCategory(product.getCategory().getName());
            responseDTO.setPrice(product.getPrice());
            responseDTO.setImageURL(product.getImageURL());
            responseDTO.setRating(product.getRating());


        return responseDTO;
    }

    public static Product covertCreateProductRequestDTOToProduct(CreateProductRequestDTO productRequestDTO){
       Product product=new Product();
       product.setName(productRequestDTO.getTitle());
       product.setPrice(productRequestDTO.getPrice());

       product.setDescription(productRequestDTO.getDescription());
       product.setImageURL(productRequestDTO.getImageURL());
       product.setRating(0);
       return product;
    }
}
