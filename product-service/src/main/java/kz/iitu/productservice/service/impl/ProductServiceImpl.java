package kz.iitu.productservice.service.impl;
import kz.iitu.productservice.model.Product;
import kz.iitu.productservice.repository.ProductRepository;
import kz.iitu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product getProductInformationById(Long id) {
        System.out.println("ProductServiceImpl.getProductInformationById");
        System.out.println("id = " + id);
        Product product = new Product();
        product.setId(id);
        product.setName("Name" + id);
        product.setDescription("Book description " + id);
        product.setManufacturer(Arrays.asList("Manufacturer #" + id));
        return product;
    }

    @Override
    public Product getProductInformationByName(String name) {
        System.out.println("ProductServiceImpl.getProductInformationByName");
        System.out.println("name = " + name);
        Product product = new Product();
        product.setName(name);
        product.setDescription("Book description " + name);
        product.setManufacturer(Arrays.asList("Manufacturer #" + name));
        return product;
    }

    @Override
    public String findProductNameById(Long id) {
        return productRepository.findById(id).get().getName();
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
            product.setName(product1.getName());
            product.setCount(product1.getCount());
            product.setDescription(product1.getDescription());
            product.setPrice(product1.getPrice());
            product.setShopId(product1.getShopId());
        }
    }
}
