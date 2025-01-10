package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.DTO.CategoryDTO.CategoryResponseDTO;
import dev.arshad.EcomProductService.DTO.CategoryDTO.CreateCategoryRequestDTO;
import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Category;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.CategoryNotFoundException;
import dev.arshad.EcomProductService.Mapper.CategoryEntityDTOMapper;
import dev.arshad.EcomProductService.Mapper.ProductEntityToDtoMapper;
import dev.arshad.EcomProductService.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public CategoryResponseDTO getCategoryById(UUID categoryId) {
        Category savedCategory=categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category not found for id:"+categoryId)
        );
        return CategoryEntityDTOMapper.covertCategoryEntityToCategorytResponseDTO(savedCategory);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        List<Category> savedCategoris=  categoryRepository.findAll();
        List<CategoryResponseDTO> responseDTO= new ArrayList<>();
        for(Category category:savedCategoris){
            responseDTO.add(CategoryEntityDTOMapper.covertCategoryEntityToCategorytResponseDTO(category));
        }
        return responseDTO;
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        Category category=CategoryEntityDTOMapper.covertCreateCategoryRequestDTOToCategory(categoryRequestDTO);

        Category savedCategory=categoryRepository.save(category);
        return CategoryEntityDTOMapper.covertCategoryEntityToCategorytResponseDTO(savedCategory);
    }

    @Override
    public CategoryResponseDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO categoryRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteCategory(UUID categoryId) {
         categoryRepository.deleteById(categoryId);
         return true;
    }
    public double getTotalPriceForCategory(UUID categoryId){
        Category category= categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category not found with id:"+categoryId));
        if(category.getProducts().isEmpty()){
            return 0;
        }else {
            double sum = 0;
            for (Product product : category.getProducts()) {
                sum = sum + product.getPrice();
            }
            return sum;
        }


    }
}
