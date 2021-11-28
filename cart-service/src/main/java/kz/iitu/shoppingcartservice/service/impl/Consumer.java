package kz.iitu.shoppingcartservice.service.impl;

import kz.iitu.shoppingcartservice.model.Order;
import kz.iitu.shoppingcartservice.service.CartItemService;
import kz.iitu.shoppingcartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @Autowired
    private CartService cartService;

    @KafkaListener(topics = "order", groupId = "group_id1")
    public void consume(Order order) throws IOException {
        System.out.println(String.format("#### -> "+ order));
        cartService.clearCart(order.getCustomerId());

    }
}