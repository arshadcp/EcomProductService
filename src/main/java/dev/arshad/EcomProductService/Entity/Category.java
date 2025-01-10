package dev.arshad.EcomProductService.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name="ECOM_CATEGORY")
public class Category extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @OneToMany(mappedBy ="category" )
    private List<Product> products;
}
