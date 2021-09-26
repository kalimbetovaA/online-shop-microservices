package kz.iitu.shoppingcartservice.service;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.Product;

public interface CartService {
    Cart getCartById(Long id);
    Product getProductsById(Long id);
    int calcTotalPrice(int price);
}
