package dev.arshad.EcomProductService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String name;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}
