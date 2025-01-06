package dev.arshad.EcomProductService.Client;

import dev.arshad.EcomProductService.DTO.FakeStoreCartResponseDTO;
import dev.arshad.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
   @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICartForUser;




   public List<FakeStoreProductResponseDTO> getAllProduct(){//we are returning an object but what we get from fakestore is json
       String getAllProductUrl=fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
       RestTemplate restTemplate=restTemplateBuilder.build();//we make the call from our serice to other service using resttemplate
       ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList=restTemplate.getForEntity(getAllProductUrl, FakeStoreProductResponseDTO[].class );//to get object from json string
       return List.of(productResponseList.getBody());
   }
   public FakeStoreProductResponseDTO getProductById(int id){
       String getProductUrl=fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath).concat("/"+id);
       RestTemplate restTemplate=restTemplateBuilder.build();
       ResponseEntity<FakeStoreProductResponseDTO> productResponse=restTemplate.getForEntity(getProductUrl, FakeStoreProductResponseDTO.class );
       return productResponse.getBody();
   }



    public List<FakeStoreCartResponseDTO> getCartByUserId(int userId) {

        if (userId < 1){
            return null;
        }
        String fakeStoreGetCartForUser = fakeStoreAPIBaseUrl.concat(fakeStoreAPICartForUser).concat(String.valueOf(userId));
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse =
                restTemplate.getForEntity(fakeStoreGetCartForUser, FakeStoreCartResponseDTO[].class);
        return List.of(cartResponse.getBody());
    }
}
