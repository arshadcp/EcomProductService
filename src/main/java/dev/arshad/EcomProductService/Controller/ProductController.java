package dev.arshad.EcomProductService.Controller;

import dev.arshad.EcomProductService.DTO.CreateProductRequestDTO;
import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;
import dev.arshad.EcomProductService.Exception.invalidInputException;
import dev.arshad.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("ProductService")
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProduct(){
        List<ProductResponseDTO> products= productService.getAllProduct();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductbyId(@PathVariable("id") UUID id) throws ProductNotFoundException {
        if (id==null){
            throw new invalidInputException("id not found");
        }
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO productRequestDTO){
        ProductResponseDTO savedProduct=productService.createProduct( productRequestDTO);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable ("id") UUID id){
        return ResponseEntity.ok( productService.deleteProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable ("id") UUID id,@RequestBody CreateProductRequestDTO productRequestDTO){
        return ResponseEntity.ok( productService.updateProduct(productRequestDTO,id));
    }

    @GetMapping("/name/{Productname}")
    public ResponseEntity<ProductResponseDTO> getProductByName(@PathVariable("Productname") String productName ){
        ProductResponseDTO savedProduct=productService.getProduct(productName);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByPriceRange(@PathVariable("min") double minPrice,
                                          @PathVariable("max") double maxPrice){
       List<ProductResponseDTO> savedProduct=productService.getProducts(minPrice,maxPrice);
       return ResponseEntity.ok(savedProduct);

    }

}

