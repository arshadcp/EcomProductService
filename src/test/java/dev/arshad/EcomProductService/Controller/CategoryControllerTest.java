package dev.arshad.EcomProductService.Controller;

import dev.arshad.EcomProductService.DTO.CategoryDTO.CategoryResponseDTO;
import dev.arshad.EcomProductService.DTO.CategoryDTO.CreateCategoryRequestDTO;
import dev.arshad.EcomProductService.Entity.Category;
import dev.arshad.EcomProductService.Service.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class CategoryControllerTest {
    @Mock
    CategoryServiceImpl categoryService ;

    @InjectMocks
    CategoryController categoryController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testUpdateCategorySuccess(){
        //Arrange
        UUID categoryid= UUID.randomUUID();
        CreateCategoryRequestDTO updaterequestDTO=new CreateCategoryRequestDTO();
        updaterequestDTO.setCategoryName("OldCategory");

        CategoryResponseDTO responseDTO=new CategoryResponseDTO();
        responseDTO.setCategoryId(categoryid);
        responseDTO.setCategoryName("NewCategory");
        Mockito.when(categoryService.updateCategory(categoryid,updaterequestDTO)).thenReturn(responseDTO);
        //Act
       ResponseEntity <CategoryResponseDTO> actualCategoryResponse=categoryController.updateCategory(categoryid,updaterequestDTO);

        //Assert
               Assertions.assertEquals(responseDTO,actualCategoryResponse.getBody());

    }

}
