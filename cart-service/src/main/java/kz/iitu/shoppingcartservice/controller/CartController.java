package kz.iitu.shoppingcartservice.controller;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
import kz.iitu.shoppingcartservice.service.CartItemService;
import kz.iitu.shoppingcartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CartItemService cartItemService;

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
    @GetMapping("/{id}/cartItem")
    public ResponseEntity<?> getCartItems(@PathVariable Long id){
        Cart cart = cartService.getCartById(id);
        return ResponseEntity.ok(cartItemService.findCartItemsByCart(cart, id));
    }
    @GetMapping("/customer/{customerid}/cart/{id}/productId")
    public ResponseEntity<?> getProductIdById(@PathVariable Long customerid, @PathVariable Long id){
        Cart cart = cartService.getCartById(id);
        CartItem cartItem = (CartItem) cart.getCartItem();
        return ResponseEntity.ok(cartItem.getId());
    }
    @GetMapping("/customer/{customerid}/cart/{id}/quantity")
    public ResponseEntity<?> getProductCountById(@PathVariable Long customerid, @PathVariable Long id){
        Cart cart = cartService.getCartById(id);
        CartItem cartItem = (CartItem) cart.getCartItem();
        return ResponseEntity.ok(cartItem.getCount());
    }
    @GetMapping("/customer/{customerid}/cart/{id}/price")
    public ResponseEntity<?> getProductPriceById(@PathVariable Long customerid, @PathVariable Long id){
        Cart cart = cartService.getCartById(id);
        CartItem cartItem = (CartItem) cart.getCartItem();
        return ResponseEntity.ok(cartItem.getPrice());
    }
}
