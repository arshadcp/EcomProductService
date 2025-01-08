package dev.arshad.EcomProductService.Entity;

import jakarta.persistence.*;
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
    @ManyToOne
    private Category category;
    private String imageURL;
    private double rating;
}
