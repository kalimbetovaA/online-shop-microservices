package kz.iitu.shoppingcartservice.repository;

import kz.iitu.shoppingcartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository <Cart, Long> {
    Cart findByCustomerId(Long customerId);
}
