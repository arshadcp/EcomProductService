package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.Entity.Category;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.CategoryNotFoundException;
import dev.arshad.EcomProductService.Repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {
   @Mock
    private CategoryRepository categoryRepository;

     @InjectMocks
    private CategoryServiceImpl categoryService;

   @BeforeEach
   public void setup(){
       MockitoAnnotations.initMocks(this);
   }
   @Test
   public void testGetTotalPriceForMultipleProductsUnderCategory(){
       //Arrange
       UUID categoryId=UUID.randomUUID();
       Optional<Category> categoryMockData=getCategoryMockdata();//what we get from repository(which we mock here) is one Category object
       Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryMockData);
       double expectedTotalPrice=150.00;
       //ACT
       double actualTotalPrice=categoryService.getTotalPriceForCategory(categoryId);
       //Assert
       Assertions.assertEquals(expectedTotalPrice,actualTotalPrice);

   }

   public Optional<Category> getCategoryMockdata(){
       Category category=new Category();
       category.setId(UUID.randomUUID());
       category.setName("Category1");

       Product prod1=new Product();
       prod1.setId(UUID.randomUUID());
       prod1.setName("p1");
       prod1.setPrice(50.00);
       prod1.setCategory(category);

       Product prod2=new Product();
       prod2.setId(UUID.randomUUID());
       prod2.setName("p2");
       prod2.setPrice(100.00);
       prod2.setCategory(category);

       List<Product> products= new ArrayList<>();
       products.add(prod1);
       products.add(prod2);
       category.setProducts(products);
       return Optional.of(category);
   }


@Test
   public void testGetTotalPriceForZero(){
       //Arrange
       UUID categoryId=UUID.randomUUID();
       Optional<Category> categoryMock=getCategoryMockDataWithZeroProducts();
       Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryMock);
      double expectedTotalCost=0.0;
    //ACT
       double actualTotalCost=categoryService.getTotalPriceForCategory(categoryId);
    //Assert
       Assertions.assertEquals(expectedTotalCost,actualTotalCost);
       Mockito.verify(categoryRepository).findById(categoryId);//this will verify that whether you have actually called this method or not
   }

   public Optional<Category> getCategoryMockDataWithZeroProducts(){
       Category category=new Category();
       category.setName("Category2");
       category.setId(UUID.randomUUID());
       List<Product> products =new ArrayList<>();
       category.setProducts(products);
       return Optional.of(category);
   }
@Test
   public void testCategoryNotFoundExceptionThrown(){
       UUID categoryId=UUID.randomUUID();

       Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());//orElseThrow throw exception if empty
       //Act & Assert
       Assertions.assertThrows(CategoryNotFoundException.class,
               ()->categoryService.getTotalPriceForCategory(categoryId));
   }
}
