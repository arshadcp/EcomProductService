package dev.arshad.EcomProductService.Repository;

import dev.arshad.EcomProductService.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findBProductByName(String productName);
    List<Product> findByPriceBetween(double minPrice,double maxPrice);

}
