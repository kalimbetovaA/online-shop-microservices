package kz.iitu.shoppingcartservice.service.impl;

import kz.iitu.shoppingcartservice.model.Cart;
import kz.iitu.shoppingcartservice.model.CartItem;
import kz.iitu.shoppingcartservice.model.Customer;
import kz.iitu.shoppingcartservice.model.Product;
import kz.iitu.shoppingcartservice.repository.CartRepository;
import kz.iitu.shoppingcartservice.service.CartItemService;
import kz.iitu.shoppingcartservice.service.CartService;
import kz.iitu.shoppingcartservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    @Override
    public Cart getCart(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }


    @Override
    public void createCart(Long customerId) {
        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cart.setTotalPrice(0);
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void addProductToCart(Long customerId, Long productId, Integer quantity) {
        if(getCart(customerId)==null){
            createCart(customerId);
        }
        Cart cart = getCart(customerId);
        Product product = productService.getProductById(productId);
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setCount(quantity);
        cartItem.setPrice(quantity*product.getPrice());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
        cart.setTotalPrice(cart.getTotalPrice()+cartItem.getPrice());
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void clearCart(Long customerId) {
        Cart cart = getCart(customerId);
        cartRepository.deleteById(cart.getId());
    }

    @Override
    public void updateCart(Cart cart) {
        Optional<Cart> optionalCart = cartRepository.findById(cart.getId());
        if(optionalCart.isPresent()){
            Cart cart1 = optionalCart.get();
            cart1.setId(cart.getId());
            cart1.setCartItems(cart.getCartItems());
            cart1.setCustomerId(cart.getCustomerId());
            cartRepository.saveAndFlush(cart1);
        }
    }

}
