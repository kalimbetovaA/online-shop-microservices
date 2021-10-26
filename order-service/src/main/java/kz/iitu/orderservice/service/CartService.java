package kz.iitu.orderservice.service;

import kz.iitu.orderservice.model.Cart;

public interface CartService {
    public Cart getCartByCustomerId(Long customerId);
}
