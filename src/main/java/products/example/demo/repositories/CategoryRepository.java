package products.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import products.example.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
