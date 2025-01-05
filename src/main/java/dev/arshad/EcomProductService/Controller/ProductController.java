package dev.arshad.EcomProductService.Controller;

import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;
import dev.arshad.EcomProductService.Exception.invalidInputException;
import dev.arshad.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getProduct(){
        List<FakeStoreProductResponseDTO> products= productService.getAllProduct();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity getProductbyId(@PathVariable("id") int id) throws ProductNotFoundException {
        if (id<0){
            throw new invalidInputException("id not found");
        }
        FakeStoreProductResponseDTO product= productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
}
