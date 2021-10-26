package kz.iitu.orderservice.service.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.orderservice.model.Cart;
import kz.iitu.orderservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    @HystrixCommand(fallbackMethod = "getCartByCustomerIdFallback")
    public Cart getCartByCustomerId(Long customerId) {
        return restTemplate.getForObject("http://cartItem-service/shopping-cart/customer/"+customerId+"/cart", Cart.class);
    }

    public Cart getCartByCustomerIdFallback(Long customerId) {
        Cart cart = new Cart();
        cart.setId(0L);
        return cart;
    }
}
