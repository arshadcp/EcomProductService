package dev.arshad.EcomProductService.Entity;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}
