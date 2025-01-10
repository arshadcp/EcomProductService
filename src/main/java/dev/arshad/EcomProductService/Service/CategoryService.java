package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.DTO.CategoryDTO.CategoryResponseDTO;
import dev.arshad.EcomProductService.DTO.CategoryDTO.CreateCategoryRequestDTO;
import dev.arshad.EcomProductService.Entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategoryById(UUID categoryId);
    List<CategoryResponseDTO> getAllCategory();
   CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
   CategoryResponseDTO updateCategory(UUID categoryId,CreateCategoryRequestDTO categoryRequestDTO);
   boolean deleteCategory(UUID categoryId);
   double getTotalPriceForCategory(UUID categoryId);
}
