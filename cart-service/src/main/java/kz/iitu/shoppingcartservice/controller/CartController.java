package kz.iitu.shoppingcartservice.controller;

import kz.iitu.shoppingcartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/customer/{customerid}/cart/{id}")
    public ResponseEntity<?> getCartById(@PathVariable Long customerid, @PathVariable Long id){
        return ResponseEntity.ok(cartService.getCartById(id));
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductsById(@PathVariable Long id){
        return ResponseEntity.ok(cartService.getProductsById(id));
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(cartService.getCustomerById(id));
    }

}
