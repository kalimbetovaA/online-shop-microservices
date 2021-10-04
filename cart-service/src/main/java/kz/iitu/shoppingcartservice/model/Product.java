package kz.iitu.shoppingcartservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Long shopId;
    private Long categoryId;
    private double price;
    private String description;
    private boolean in_stock;
}
