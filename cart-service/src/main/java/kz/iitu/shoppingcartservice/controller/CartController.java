package kz.iitu.shoppingcartservice.controller;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.service.CartItemService;
import kz.iitu.shoppingcartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<?> createCart(@PathVariable Long customerId){
        cartService.createCart(customerId);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/customer/{customerId}/cart")
    public ResponseEntity<?> getCart(@PathVariable Long customerId){
        Cart cart = cartService.getCart(customerId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/customer/{customerId}/addCartItem")
    public ResponseEntity<?> addCartItem(@PathVariable Long customerId, @RequestParam Long productId, @RequestParam Integer quantity){
        cartService.addProductToCart(customerId, productId, quantity);
        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long customerId){
        cartService.clearCart(customerId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Cart cart){
        cart.setId(id);
        cartService.updateCart(cart);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
