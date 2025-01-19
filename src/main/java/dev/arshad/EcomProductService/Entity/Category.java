package dev.arshad.EcomProductService.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
//(name="ecom_category")
@Getter
@Setter
@Entity
@Table(name="ecom_category")
public class Category extends BaseModel{

    private String name;
    @OneToMany(mappedBy ="category" )
    private List<Product> products;
}
