package kz.iitu.productcategoryservice.service;

import kz.iitu.productcategoryservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductCategoryService {
    List<Product> getAllProduct();
}
