package kz.iitu.shoppingcartservice.model;


import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class Order {
    private Long id;
    private Long customerId;
    private Double totalPrice;
    private String deliverAddress;
    private Boolean deliverStatus;
    private List<OrderItem> orderItems;
}
