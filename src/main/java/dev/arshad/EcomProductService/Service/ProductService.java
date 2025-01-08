package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.DTO.CreateProductRequestDTO;
import dev.arshad.EcomProductService.DTO.ProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
   List<ProductResponseDTO> getAllProduct();
   ProductResponseDTO getProductById(UUID productId) throws ProductNotFoundException;
   boolean deleteProduct(UUID productid);
   ProductResponseDTO createProduct(CreateProductRequestDTO product);
   ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct,UUID productId);
   ProductResponseDTO getProduct(String productName);
   List<ProductResponseDTO> getProducts(double minPrice,double maxPrice);
}
