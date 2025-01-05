package dev.arshad.EcomProductService.Exception;

import dev.arshad.EcomProductService.Controller.ProductController;
import dev.arshad.EcomProductService.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class, NoProductFoundException.class})
    public ResponseEntity handleNoProductException(ProductNotFoundException pe){
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                pe.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(invalidInputException.class)
    public ResponseEntity handleInvalidRequestException(invalidInputException invalidRequest) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
               invalidRequest.getMessage(),
                400
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);

    }

}