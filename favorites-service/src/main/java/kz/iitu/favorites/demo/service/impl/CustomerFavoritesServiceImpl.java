package kz.iitu.favorites.demo.service.impl;

import kz.iitu.favorites.demo.model.CustomerFavorites;
import kz.iitu.favorites.demo.model.FavProduct;
import kz.iitu.favorites.demo.repository.CustomerFavoritesRepository;
import kz.iitu.favorites.demo.repository.FavProductRepository;
import kz.iitu.favorites.demo.service.CustomerFavoritesService;
import kz.iitu.favorites.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerFavoritesServiceImpl implements CustomerFavoritesService {

    @Autowired
    private CustomerFavoritesRepository customerFavoritesRepository;

    @Autowired
    private FavProductRepository favProductRepository;

    @Autowired
    private ProductService productService;


    @Override
    public CustomerFavorites getCustomerFavorites(Long customerId) {
        return customerFavoritesRepository.findByCustomerId(customerId);
    }


    @Override
    public void createCustomerFavorites(Long customerId) {
        CustomerFavorites customerFavorites = new CustomerFavorites();
        customerFavorites.setCustomerId(customerId);
        customerFavoritesRepository.saveAndFlush(customerFavorites);
    }

    @Override
    public void addToFav(Long customerId, Long productId) {
        if(getCustomerFavorites(customerId)==null){
            createCustomerFavorites(customerId);
        }
        CustomerFavorites customerFavorites = getCustomerFavorites(customerId);
        FavProduct favProduct = productService.getProductById(productId);

        favProduct.setFavorites(customerFavorites);
        favProductRepository.save(favProduct);
    }

    @Override
    public void removeFromFav(Long customerId, Long productId) {
        if(getCustomerFavorites(customerId)==null){
            createCustomerFavorites(customerId);
        }
        CustomerFavorites customerFavorites = getCustomerFavorites(customerId);
        FavProduct favProduct = productService.getProductById(productId);

        favProduct.setFavorites(customerFavorites);
        favProductRepository.delete(favProduct);
    }


    @Override
    public void updateCustomerFavorites(CustomerFavorites customerFavorites) {
        Optional<CustomerFavorites> optionalCustomerFavorites = customerFavoritesRepository.findById(customerFavorites.getId());
        if(optionalCustomerFavorites.isPresent()){
            CustomerFavorites customerFavorites1 = optionalCustomerFavorites.get();
            customerFavorites1.setId(customerFavorites.getId());
            customerFavorites1.setFavProducts(customerFavorites.getFavProducts());
            customerFavorites1.setCustomerId(customerFavorites.getCustomerId());
            customerFavoritesRepository.saveAndFlush(customerFavorites1);
        }
    }

}
