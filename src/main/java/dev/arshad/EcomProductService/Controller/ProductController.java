package dev.arshad.EcomProductService.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.arshad.EcomProductService.Client.UserServiceClient;
import dev.arshad.EcomProductService.DTO.CreateProductRequestDTO;
import dev.arshad.EcomProductService.DTO.JwtPayloadDTO;
import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import dev.arshad.EcomProductService.DTO.ValidateTokenDTO;
import dev.arshad.EcomProductService.Entity.Enum.SessionStatus;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;
import dev.arshad.EcomProductService.Exception.invalidInputException;
import dev.arshad.EcomProductService.Exception.invalidTokenException;
import dev.arshad.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("ProductService")
    private ProductService productService;
    @Autowired
    private UserServiceClient userServiceClient;


    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProduct(@RequestHeader ("Authorisation") String token)throws Exception{
       validateUser(token);
       // userServiceClient.validateToken();
        List<ProductResponseDTO> products= productService.getAllProduct();

        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductbyId(@RequestHeader ("Authorisation") String token,@PathVariable("id") UUID id) throws ProductNotFoundException {
        if (id==null){
            throw new invalidInputException("id not found");
        }
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestHeader ("Authorisation") String token,@RequestBody CreateProductRequestDTO productRequestDTO){
        ProductResponseDTO savedProduct=productService.createProduct( productRequestDTO);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@RequestHeader ("Authorisation") String token,@PathVariable ("id") UUID id){
        return ResponseEntity.ok( productService.deleteProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestHeader ("Authorisation") String token,@PathVariable ("id") UUID id,@RequestBody CreateProductRequestDTO productRequestDTO){
        return ResponseEntity.ok( productService.updateProduct(productRequestDTO,id));
    }

    @GetMapping("/name/{Productname}")
    public ResponseEntity<ProductResponseDTO> getProductByName(@RequestHeader ("Authorisation") String token,@PathVariable("Productname") String productName ){
        ProductResponseDTO savedProduct=productService.getProduct(productName);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByPriceRange(@PathVariable("min") double minPrice,
                                          @PathVariable("max") double maxPrice){
       List<ProductResponseDTO> savedProduct=productService.getProducts(minPrice,maxPrice);
       return ResponseEntity.ok(savedProduct);

    }
    public void validateUser(String token)throws Exception{
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));
        ObjectMapper mapper = new ObjectMapper();
        JwtPayloadDTO payloadDTO=mapper.readValue(payload, JwtPayloadDTO.class);

        String userId=payloadDTO.getUserId();
        ValidateTokenDTO validateTokenDTO = new ValidateTokenDTO(userId, token);
        String result = userServiceClient.validateToken(validateTokenDTO);
        if(!result.contains(SessionStatus.ACTIVE.name())){
            throw new invalidTokenException("Token is not valid");
        }
    }

}

