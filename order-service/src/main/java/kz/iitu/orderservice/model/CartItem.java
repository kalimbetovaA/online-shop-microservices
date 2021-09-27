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
    private String name;
    private List<String> manufacturer;
    private double price;
    private int count;
    private String description;
    private boolean in_stock;
    private Long productId;
}
