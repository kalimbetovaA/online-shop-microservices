package kz.iitu.shoppingcartservice.service;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
import kz.iitu.shoppingcartservice.model.Customer;

public interface CartService {
    Cart getCartById(Long id);
    CartItem getProductsById(Long id);
    Customer getCustomerById(Long id);
    double calcTotalPrice(double price);
    Long getProductIdById(Long id);
    int getProductCountById(Long id);
    Double getProductPriceById(Long id);
}
