package kz.iitu.shoppingcartservice.service.impl;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
import kz.iitu.shoppingcartservice.repository.CartItemRepository;
import kz.iitu.shoppingcartservice.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> findAllByOrder(Cart cart) {
        return null;
    }

    @Override
    public CartItem findCartItemsByCart(Cart cart, Long id) {
        return cartItemRepository.findById(id).get();
    }
}
