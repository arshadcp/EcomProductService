package dev.arshad.EcomProductService.Controller;

import dev.arshad.EcomProductService.DTO.CategoryDTO.CategoryResponseDTO;
import dev.arshad.EcomProductService.DTO.CategoryDTO.CreateCategoryRequestDTO;
import dev.arshad.EcomProductService.Entity.Category;
import dev.arshad.EcomProductService.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") UUID categoryId){
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CreateCategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable ("id") UUID categoryId,
                                         @RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){
        return ResponseEntity.ok(categoryService.updateCategory(categoryId,createCategoryRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID categoryId){
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }

    @GetMapping("totalPrice/{CategoryId}")
    public ResponseEntity<Double> getProductPrice(@PathVariable("CategoryId") UUID categoryId){
        return ResponseEntity.ok(categoryService.getTotalPriceForCategory(categoryId));
    }

}
