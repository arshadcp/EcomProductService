package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.Client.FakeStoreClient;
import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class FakeStoreProductServiceImpl implements ProductService{
    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProduct() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts= fakeStoreClient.getAllProduct();
        return fakeStoreProducts;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return true;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        return null;
    }
    public Product createProduct(Product product){
        return null;
    }
}
