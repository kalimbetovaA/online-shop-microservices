package kz.iitu.orderservice.service.Impl;

import kz.iitu.orderservice.model.Cart;
import kz.iitu.orderservice.model.CartItem;
import kz.iitu.orderservice.model.Order;
import kz.iitu.orderservice.model.OrderItem;
import kz.iitu.orderservice.repository.OrderItemRepository;
import kz.iitu.orderservice.repository.OrderRepository;
import kz.iitu.orderservice.service.OrderItemService;
import kz.iitu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findCustomerOrders(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void createOrder(Long customerId) {

        Order newOrder = new Order();
        String deliverAddress = restTemplate.getForObject("http://localhost:8081/customers/"+customerId+"/address", String.class);
        newOrder.setCustomerId(customerId);
        newOrder.setDeliverAddress(deliverAddress);

        Cart cart = restTemplate.getForObject("http://localhost:8085/shopping-cart/customer/"+customerId+"/cart", Cart.class);

        newOrder.setTotalPrice(cart.getTotalPrice());

        for (CartItem cartItem : cart.getCartItem()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setQuantity(cartItem.getCount());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setOrder(newOrder);

            orderItemService.addOrderItem(orderItem);
        }

        orderRepository.save(newOrder);
        restTemplate.delete("http://localhost:8085/shopping-cart/customer/"+customerId);
    }

    @Override
    public void updateOrder(Long id, Order order) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            Order dbOrder = orderOptional.get();
            dbOrder.setCustomerId(order.getCustomerId());
            dbOrder.setTotalPrice(order.getTotalPrice());
            dbOrder.setDeliverStatus(order.getDeliverStatus());
            orderRepository.save(dbOrder);
        }
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            orderRepository.deleteById(id);
        }
    }
}
