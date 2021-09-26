package kz.iitu.orderservice.service.Impl;

import kz.iitu.orderservice.model.Order;
import kz.iitu.orderservice.model.OrderItem;
import kz.iitu.orderservice.repository.OrderItemRepository;
import kz.iitu.orderservice.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findOrderItemsByOrder(Order order) {
        return orderItemRepository.findAllByOrder(order);
    }

    @Override
    public OrderItem findOrderItemById(Long id) {
            return orderItemRepository.findById(id).get();
        }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
}
