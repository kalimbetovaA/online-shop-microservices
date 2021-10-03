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
public class CartItem {

    private Long id;
    private Long productId;
    private int count;
    private double price;
    private String description;
    private Cart cart;
}
