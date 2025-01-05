package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
   List<FakeStoreProductResponseDTO> getAllProduct();
   FakeStoreProductResponseDTO getProductById(int productId) throws ProductNotFoundException;
   boolean deleteProduct(int productid);
   Product createProduct(Product product);
   Product updateProduct(Product updatedProduct,int productId);
}
