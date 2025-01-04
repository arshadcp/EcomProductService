package dev.arshad.EcomProductService.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class FakeStoreProductRatingDTO {
 private double rate;
 private int count;
}
