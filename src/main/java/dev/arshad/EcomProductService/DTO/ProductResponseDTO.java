package dev.arshad.EcomProductService.DTO;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class ProductResponseDTO {
    private int productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;

}
