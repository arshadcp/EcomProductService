package dev.arshad.EcomProductService.Service;

import dev.arshad.EcomProductService.Client.FakeStoreClient;
import dev.arshad.EcomProductService.DTO.FakeStoreDTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import dev.arshad.EcomProductService.Exception.NoProductFoundException;
import dev.arshad.EcomProductService.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl {
    @Autowired
    private FakeStoreClient fakeStoreClient;


    public List<FakeStoreProductResponseDTO> getAllProduct() throws NoProductFoundException {
        List<FakeStoreProductResponseDTO> fakeStoreProducts= fakeStoreClient.getAllProduct();
        if(fakeStoreProducts==null){
            throw new NoProductFoundException("No products are found");
        }
        return fakeStoreProducts;
    }


    public FakeStoreProductResponseDTO getProductById(int id) throws ProductNotFoundException{
      FakeStoreProductResponseDTO responseDTO=  fakeStoreClient.getProductById(id);
      if(responseDTO==null){
          throw new ProductNotFoundException("Product not found with id:"+id);
      }
      return responseDTO;
    }


    public boolean deleteProduct(int id) {
        return true;
    }


    public Product updateProduct(Product product, int productId) {
        return null;
    }
    public Product createProduct(Product product){
        return null;
    }
}
