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
@Table(name = "cart")
public class Cart {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private double totalPrice;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartItem> cartItem;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
