package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.Repository.CategoryRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CategoryServiceImplTest {
    @Mock
   private CategoryRepository categoryRepository;

    @InjectMocks
    private  CategoryServiceImpl categoryService;
}
