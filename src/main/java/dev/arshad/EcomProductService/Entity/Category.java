package dev.arshad.EcomProductService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;
    @OneToMany
    private List<Product> products;
}
