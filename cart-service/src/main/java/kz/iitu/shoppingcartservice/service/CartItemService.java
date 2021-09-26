package kz.iitu.shoppingcartservice.service;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;

import java.util.List;

public interface CartItemService{
    public List<CartItem> findAllByOrder(Cart cart);

    public CartItem findCartItemsByCart(Cart cart, Long id);
}
