package dev.arshad.EcomProductService.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class ValidateTokenDTO {
    private String userId;
    private String token;

    public ValidateTokenDTO(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }
    public ValidateTokenDTO() {
    }

}
