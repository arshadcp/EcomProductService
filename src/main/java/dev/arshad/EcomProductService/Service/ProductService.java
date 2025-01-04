package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;

import java.util.List;

public interface ProductService {
   List<FakeStoreProductResponseDTO> getAllProduct();
   Product getProductById(int productId);
   boolean deleteProduct(int productid);
   Product createProduct(Product product);
   Product updateProduct(Product updatedProduct,int productId);
}
