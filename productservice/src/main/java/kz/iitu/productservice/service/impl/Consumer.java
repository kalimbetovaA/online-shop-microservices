package kz.iitu.productservice.service.impl;


import kz.iitu.productservice.model.Order;
import kz.iitu.productservice.model.OrderItem;
import kz.iitu.productservice.model.Product;
import kz.iitu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "order", groupId = "group_id")
    public void consume(Order order) throws IOException {
        System.out.println(String.format("#### -> "+ order.toString()));

        for (OrderItem orderItem : order.getOrderItems()) {
            Long productId=orderItem.getProductId();
            Product product=productService.findProductById(productId);
            product.setCount(product.getCount()-1);
            productService.updateProduct(product);
            System.out.println(product);
        }

    }
}