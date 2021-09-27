package kz.iitu.shoppingcartservice.controller;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
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
        return ResponseEntity.ok(cartItem.getProductId());
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
    @PostMapping("")
    public ResponseEntity<?> createProduct(@PathVariable Cart cart){
        cartService.createCart(cart);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        cartService.deleteCart(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@PathVariable Cart cart){
        cart.setId(id);
        cartService.updateCart(cart);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
