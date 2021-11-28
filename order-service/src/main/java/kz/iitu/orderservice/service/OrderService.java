package kz.iitu.orderservice.service;

import kz.iitu.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findAllOrders();

    public List<Order> findCustomerOrders(Long customerId);

    public Order findOrderById(Long id);

    public Order createOrder(Long customerId);

    public void updateOrder(Long id, Order order);

    public void deleteOrder(Long id);
}
