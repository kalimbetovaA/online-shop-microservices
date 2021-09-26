package kz.iitu.orderservice.service;

import kz.iitu.orderservice.model.Order;
import kz.iitu.orderservice.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    public List<OrderItem> findOrderItemsByOrder(Order order);

    public OrderItem findOrderItemById(Long id);

    public void addOrderItem(OrderItem orderItem);
}
