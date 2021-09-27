package kz.iitu.shoppingcartservice.service.impl;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
import kz.iitu.shoppingcartservice.model.Customer;
import kz.iitu.shoppingcartservice.repository.CartRepository;
import kz.iitu.shoppingcartservice.service.CartItemService;
import kz.iitu.shoppingcartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CartServiceImpl implements CartService {
    @Autowired
    private RestTemplate restTemplate;
    double totalprice = 0;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemService cartItemService;

    @Override
    public Cart getCartById(Long id) {
        System.out.println("CartServiceImpl.getCartById");
        System.out.println("id = " + id);
        Cart cart = new Cart();
        cart.setId(id);
        cart.setTotalPrice(totalprice);
        return cart;
    }

    @Override
    public CartItem getProductsById(Long id) {
        CartItem cartItem = restTemplate.getForObject("http://localhost/product/" + id, CartItem.class);
        totalprice = calcTotalPrice(cartItem.getPrice());
        return cartItem;
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = restTemplate.getForObject("http://localhost/customer/" + id, Customer.class);
        return customer;
    }

    @Override
    public double calcTotalPrice(double price) {
        totalprice+=price;
        return totalprice;
    }

    @Override
    public Long getProductIdById(Long id) {
        CartItem cartItem = restTemplate.getForObject("http://localhost/product/" + id, CartItem.class);
        return cartItem.getProductId();
    }

    @Override
    public int getProductCountById(Long id) {
        CartItem cartItem = restTemplate.getForObject("http://localhost/product/" + id, CartItem.class);
        return cartItem.getCount();
    }

    @Override
    public Double getProductPriceById(Long id) {
        CartItem cartItem = restTemplate.getForObject("http://localhost/product/" + id, CartItem.class);
        return cartItem.getPrice();
    }

}
