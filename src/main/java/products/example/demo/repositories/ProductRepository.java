package products.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import products.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
