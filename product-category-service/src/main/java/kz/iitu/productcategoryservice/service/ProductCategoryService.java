package kz.iitu.productcategoryservice.service;

import kz.iitu.productcategoryservice.model.Product;
import kz.iitu.productcategoryservice.model.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductCategoryService {
    public List<ProductCategory> findAllCategories();

    public List<Product> getAllProducts(Long id);

    public ProductCategory findProductCategoryById(Long id);

    public void addProductCategory(ProductCategory category);

    public void deleteProductCategory(Long id);

    public void updateProductCategory(ProductCategory productCategory);
}
