package kz.iitu.favorites.demo.service;


import kz.iitu.favorites.demo.model.FavProduct;

public interface ProductService {

    public FavProduct getProductById(Long productId);
}
