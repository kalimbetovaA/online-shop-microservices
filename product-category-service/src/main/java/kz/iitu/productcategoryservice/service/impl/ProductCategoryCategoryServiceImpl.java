package kz.iitu.productcategoryservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.productcategoryservice.model.Product;
import kz.iitu.productcategoryservice.model.ProductCategory;
import kz.iitu.productcategoryservice.repository.ProductCategoryRepository;
import kz.iitu.productcategoryservice.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getAllProductsFallback",
            threadPoolKey = "getAllProducts",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="90"),
                    @HystrixProperty(name="maxQueueSize", value="40"),
            }
    )
    public List<Product> getAllProducts(Long id) {

        List<Product> productList  = restTemplate.getForObject("http://productservice/products/category/"+ id, List.class);
        return productList;
    }

    public List<Product> getAllProductsFallback(Long id) {
        return new ArrayList<Product>();
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
