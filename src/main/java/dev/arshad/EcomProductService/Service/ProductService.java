package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
   List<Product> getAllProduct();
   Product getProductById(UUID productId) throws ProductNotFoundException;
   boolean deleteProduct(UUID productid);
   Product createProduct(Product product);
   Product updateProduct(Product updatedProduct,UUID productId);
   Product getProduct(String productName);
   List<Product> getProducts(double minPrice,double maxPrice);
}
