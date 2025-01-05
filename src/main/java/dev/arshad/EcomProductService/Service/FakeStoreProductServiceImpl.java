package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.Client.FakeStoreClient;
import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.NoProductFoundException;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class FakeStoreProductServiceImpl implements ProductService{
    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProduct() throws NoProductFoundException {
        List<FakeStoreProductResponseDTO> fakeStoreProducts= fakeStoreClient.getAllProduct();
        if(fakeStoreProducts==null){
            throw new NoProductFoundException("No products are found");
        }
        return fakeStoreProducts;
    }

    @Override
    public FakeStoreProductResponseDTO getProductById(int id) throws ProductNotFoundException{
      FakeStoreProductResponseDTO responseDTO=  fakeStoreClient.getProductById(id);
      if(responseDTO==null){
          throw new ProductNotFoundException("Product not found with id:"+id);
      }
      return responseDTO;
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
