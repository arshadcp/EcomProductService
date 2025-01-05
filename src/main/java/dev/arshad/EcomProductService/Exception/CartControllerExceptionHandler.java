package dev.arshad.EcomProductService.Exception;

import dev.arshad.EcomProductService.Controller.CartController;
import dev.arshad.EcomProductService.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler(invalidCartException.class)
    public ResponseEntity handleCartException(invalidCartException invalidCart){
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                invalidCart.getMessage(),
                400
        );
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.BAD_REQUEST);
    }
}
