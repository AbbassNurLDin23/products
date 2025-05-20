package products.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "productsdb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

    @DecimalMin(value = "0.00", inclusive = true, message = "Price must be positive")
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "salePercentage")
    private int salePercentage;

    @DecimalMin(value = "0.00", inclusive = true, message = "Price must be positive")
    @Column(name = "salePrice")
    private BigDecimal salePrice;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")  // foreign key column in product table
    @JsonBackReference
    private Category category;
}
