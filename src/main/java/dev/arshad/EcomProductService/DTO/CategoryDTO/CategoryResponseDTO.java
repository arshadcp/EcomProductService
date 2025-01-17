package dev.arshad.EcomProductService.DTO.CategoryDTO;

import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDTO {
 private UUID categoryId;
 private String categoryName;
 private List<ProductResponseDTO> products;
}
