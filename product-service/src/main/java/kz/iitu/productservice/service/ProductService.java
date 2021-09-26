package kz.iitu.productservice.service;

import kz.iitu.productservice.model.Product;

public interface ProductService {
    Product getProductInformationById(Long id);
    Product getProductInformationByName(String name);
}
