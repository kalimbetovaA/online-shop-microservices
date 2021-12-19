package kz.iitu.favorites.demo.service;


import kz.iitu.favorites.demo.model.CustomerFavorites;
import org.springframework.stereotype.Service;

@Service
public interface CustomerFavoritesService {
    CustomerFavorites getCustomerFavorites(Long customerId);
    void createCustomerFavorites(Long customerId);
    void updateCustomerFavorites(CustomerFavorites cart);
    void addToFav(Long customerId, Long productId);
    void removeFromFav(Long customerId, Long productId);
}
