package dev.arshad.EcomProductService.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class JwtPayloadDTO {
    private Date createdAt;
    private List<String> roles;
    private String userId;


    @JsonCreator
    public JwtPayloadDTO(
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("Roles") List<String> roles,
            @JsonProperty("User_id") String userId
           ) {
        this.createdAt = createdAt;
        this.roles = roles;
        this.userId = userId;

    }
}
