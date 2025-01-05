package dev.arshad.EcomProductService.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDTO {
    private String message;
    private int code;//error code

    public ExceptionResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }
    public ExceptionResponseDTO(){

    }
}
