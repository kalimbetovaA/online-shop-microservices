package kz.iitu.orderservice.controller;

import kz.iitu.orderservice.model.Order;
import kz.iitu.orderservice.service.OrderItemService;
import kz.iitu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomerOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.findCustomerOrders(customerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findOrderById(id));
    }

    @GetMapping("/{id}/orderItems")
    public ResponseEntity<?> getOrderItems(@PathVariable Long id) {
        Order order = orderService.findOrderById(id);
        return ResponseEntity.ok(orderItemService.findOrderItemsByOrder(order));
    }

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<?> createOrder(@PathVariable Long customerId) {
        orderService.createOrder(customerId);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        orderService.updateOrder(id, order);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
