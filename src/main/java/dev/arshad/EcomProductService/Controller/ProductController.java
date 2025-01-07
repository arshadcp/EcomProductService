package dev.arshad.EcomProductService.Controller;

import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
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
    public ResponseEntity getProduct(){
        List<Product> products= productService.getAllProduct();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity getProductbyId(@PathVariable("id") UUID id) throws ProductNotFoundException {
        if (id==null){
            throw new invalidInputException("id not found");
        }
        Product product= productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        Product savedProduct=productService.createProduct( product);
        return ResponseEntity.ok(savedProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable ("id") UUID id){
        return ResponseEntity.ok( productService.deleteProduct(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable ("id") UUID id,@RequestBody Product product){
        return ResponseEntity.ok( productService.updateProduct(product,id));
    }

    @GetMapping("/name/{Productname}")
    public ResponseEntity getProductByName(@PathVariable("Productname") String productName ){
        Product savedProduct=productService.getProduct(productName);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductByPriceRange(@PathVariable("min") double minPrice,
                                          @PathVariable("max") double maxPrice){
       List<Product> savedProduct=productService.getProducts(minPrice,maxPrice);
       return ResponseEntity.ok(savedProduct);

    }

}
