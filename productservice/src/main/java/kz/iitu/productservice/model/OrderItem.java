package kz.iitu.productservice.model;

import lombok.Getter;

@Getter
public class OrderItem {
    private Long id;
    private Long productId;
    private int quantity;
    private double price;

    private Order order;
}
