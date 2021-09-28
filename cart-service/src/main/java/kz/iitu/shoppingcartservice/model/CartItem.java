package kz.iitu.shoppingcartservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartItem {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int count;
    private String description;
    private boolean in_stock;
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
