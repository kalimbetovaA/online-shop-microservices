package kz.iitu.productcategoryservice.service.impl;

import kz.iitu.productcategoryservice.model.Product;
import kz.iitu.productcategoryservice.model.ProductCategory;
import kz.iitu.productcategoryservice.repository.ProductCategoryRepository;
import kz.iitu.productcategoryservice.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Product> getAllProducts(Long id) {

        List<Product> productList  = restTemplate.getForObject("http://productservice/products/category/"+ id, List.class);
        return productList;
    }

    @Override
    public List<ProductCategory> findAllCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory findProductCategoryById(Long id) {
        return productCategoryRepository.findById(id).get();
    }

    @Override
    public void addProductCategory(ProductCategory category) {
        productCategoryRepository.save(category);
    }

    @Override
    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public void updateProductCategory(ProductCategory productCategory) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(productCategory.getId());

        if (productCategoryOptional.isPresent()) {
            ProductCategory dbShop = productCategoryOptional.get();
            dbShop.setName(productCategory.getName());
            productCategoryRepository.saveAndFlush(dbShop);
        }
    }
}
