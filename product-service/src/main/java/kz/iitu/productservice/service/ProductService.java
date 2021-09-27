package kz.iitu.productservice.service;

import kz.iitu.productservice.model.Product;

public interface ProductService {
    Product getProductInformationById(Long id);
    Product getProductInformationByName(String name);
    String findProductNameById(Long id);
    void createProduct(Product product);
    void deleteProduct(Long id);
    void updateProduct(Product product);
}
