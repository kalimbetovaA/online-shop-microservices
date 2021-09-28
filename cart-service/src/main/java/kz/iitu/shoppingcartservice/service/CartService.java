package kz.iitu.shoppingcartservice.service;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
import kz.iitu.shoppingcartservice.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Cart getCart(Long customerId);
    void createCart(Long customerId);
    void updateCart(Cart cart);
    void clearCart(Long customerId);
    void addProductToCart(Long customerId, Long productId, Integer quantity);
}
