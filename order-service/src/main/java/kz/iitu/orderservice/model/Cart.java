package kz.iitu.orderservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Cart {

    private Long id;
    private Long customerId;
    private double totalPrice;
    private List<CartItem> cartItems;
}
