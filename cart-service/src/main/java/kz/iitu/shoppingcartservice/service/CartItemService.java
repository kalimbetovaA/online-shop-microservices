package kz.iitu.shoppingcartservice.service;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartItemService{
    public List<CartItem> findAllByOrder(Cart cart);

    public CartItem findCartItemsByCart(Cart cart, Long id);
}
