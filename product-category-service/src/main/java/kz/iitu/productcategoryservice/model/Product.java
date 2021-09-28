package kz.iitu.productcategoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private int price;
    private int count;
    private String description;
    private boolean in_stock;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Product> productList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
