package kz.iitu.shoppingcartservice.controller;

import kz.iitu.shoppingcartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCartById(@PathVariable Long id){
        return ResponseEntity.ok(cartService.getCartById(id));
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductsById(@PathVariable Long id){
        return ResponseEntity.ok(cartService.getProductsById(id));
    }
    @GetMapping("/")
    public ResponseEntity<?> calcTotalPrice(@PathVariable int price){
        return null;
    }
}
