package kz.iitu.productservice.service.impl;
import kz.iitu.productservice.model.Product;
import kz.iitu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ProductServiceImpl implements ProductService {

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
}
