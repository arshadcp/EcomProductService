package dev.arshad.EcomProductService.Client;

import dev.arshad.EcomProductService.DTO.FakeStoreDTO.FakeStoreProductResponseDTO;
import dev.arshad.EcomProductService.DTO.ValidateTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserServiceClient {
    @Autowired
   private RestTemplateBuilder restTemplateBuilder;

   @Value( "${userservice.api.base.url}")
   private String userServiceBaseUrl;

   @Value("${userservice.api.path.validate}")
    private String userServiceValidateUrlPath;





    public String validateToken(ValidateTokenDTO validateTokenDTO){
        String validateTokenURL  = userServiceBaseUrl + userServiceValidateUrlPath;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> validateTokenResponse =
                restTemplate.postForEntity(validateTokenURL, validateTokenDTO, String.class);
        return validateTokenResponse.getBody();
    }

}
