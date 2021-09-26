package kz.iitu.shoppingcartservice.service.impl;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.Product;
import kz.iitu.shoppingcartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CartServiceImpl implements CartService {
    @Autowired
    private RestTemplate restTemplate;
    int totalprice = 0;
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
    public Product getProductsById(Long id) {
        Product product = restTemplate.getForObject("http://localhost/product/" + id, Product.class);
        totalprice = calcTotalPrice(product.getPrice());
        return product;
    }

    @Override
    public int calcTotalPrice(int price) {
        totalprice+=price;
        return totalprice;
    }

}
