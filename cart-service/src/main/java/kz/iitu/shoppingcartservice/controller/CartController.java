package kz.iitu.shoppingcartservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Method to Create a new Cart for specific Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("/customer/{customerId}")
    public ResponseEntity<?> createCart(@PathVariable Long customerId){
        cartService.createCart(customerId);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "To get Cart info of specific Customer by its Id", response = Cart.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Cart object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/customer/{customerId}/cart")
    public ResponseEntity<?> getCart(@PathVariable Long customerId){
        Cart cart = cartService.getCart(customerId);
        return ResponseEntity.ok(cart);
    }

    @ApiOperation(value = "Method to add a new Cart Item for specific Customer Cart")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("/customer/{customerId}/addCartItem")
    public ResponseEntity<?> addCartItem(@PathVariable Long customerId, @RequestParam Long productId, @RequestParam Integer quantity){
        cartService.addProductToCart(customerId, productId, quantity);
        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @ApiOperation(value = "Method to Delete a Cart by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long customerId){
        cartService.clearCart(customerId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "Method to Update Customer Cart by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Cart cart){
        cart.setId(id);
        cartService.updateCart(cart);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
