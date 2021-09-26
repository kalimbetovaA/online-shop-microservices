package kz.iitu.shoppingcartservice.repository;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository <CartItem, Long> {
    List<CartItem> findAllByCart(Cart cart);
}
