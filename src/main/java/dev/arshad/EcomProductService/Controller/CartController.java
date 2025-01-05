package dev.arshad.EcomProductService.Controller;

import dev.arshad.EcomProductService.Client.FakeStoreClient;
import dev.arshad.EcomProductService.DTO.FakeStoreCartResponseDTO;
import dev.arshad.EcomProductService.Exception.invalidCartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {


//    @GetMapping("/cart/{userId}")
//    public ResponseEntity getCartByUserId(@PathVariable ("userId") int userId) throws invalidCartException,Exception {
//       List<FakeStoreCartResponseDTO> cartResponse=fakeStoreClient.getCartByUserId(userId);
//       if(cartResponse==null){
//           throw new invalidCartException("Cart not found for the userId"+userId);
//       }
//        return ResponseEntity.ok(cartResponse);
//    }

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDTO> cartResponse = fakeStoreClient.getCartByUserId(userId);
        if(cartResponse == null){
            throw new invalidCartException("Cart not found for userID " + userId);
        }
        return ResponseEntity.ok(cartResponse);
    }
}
