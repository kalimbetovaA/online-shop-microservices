package kz.iitu.productservice.service;

import kz.iitu.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    List<Product> getShopProducts(Long shopId);
    List<Product> getCategoryProducts(Long categoryId);
    Product findProductById(Long id);
    void createProduct(Product product);
    void deleteProduct(Long id);
    void updateProduct(Product product);
}
