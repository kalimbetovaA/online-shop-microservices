package kz.iitu.shopservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Long shopId;
    private Long categoryId;
    private double price;
    private String description;
    private boolean in_stock;
}
