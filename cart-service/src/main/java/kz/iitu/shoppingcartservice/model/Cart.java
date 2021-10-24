package kz.iitu.shoppingcartservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Cart ID")
    private Long id;
    @ApiModelProperty(notes = "The Cart Customer ID")
    private Long customerId;
    @ApiModelProperty(notes = "The Cart total price")
    private double totalPrice;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "The Cart Items list")
    private List<CartItem> cartItems;


}
