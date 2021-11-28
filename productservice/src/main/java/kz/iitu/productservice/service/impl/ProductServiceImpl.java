package kz.iitu.productservice.service.impl;
import kz.iitu.productservice.model.Product;
import kz.iitu.productservice.repository.ProductRepository;
import kz.iitu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getShopProducts(Long shopId) {
        System.out.println("test");
        return productRepository.findByShopId(shopId);
    }

    @Override
    public List<Product> getCategoryProducts(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            productRepository.deleteById(id);
        }
    }

    @Override
    public void updateProduct(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if(productOptional.isPresent()){
            Product product1 = productOptional.get();
            product1.setName(product.getName());
            product1.setCategoryId(product.getCategoryId());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            product1.setShopId(product.getShopId());
            product1.setCount(product.getCount());
            productRepository.saveAndFlush(product1);
        }
    }
}
