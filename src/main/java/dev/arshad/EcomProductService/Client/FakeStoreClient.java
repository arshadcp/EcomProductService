package dev.arshad.EcomProductService.Client;

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




   public List<FakeStoreProductResponseDTO> getAllProduct(){//we are returning an object but what we get from fakestore is json
       String getAllProductUrl=fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
       RestTemplate restTemplate=restTemplateBuilder.build();//we make the call using resttemplate
       ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList=restTemplate.getForEntity(getAllProductUrl, FakeStoreProductResponseDTO[].class );//to get object from json string
       return List.of(productResponseList.getBody());
   }
}