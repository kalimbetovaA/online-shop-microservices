package kz.iitu.productcategoryservice.service.impl;

import kz.iitu.productcategoryservice.model.Product;
import kz.iitu.productcategoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();

        List<Long> productIds = new ArrayList<>(Arrays.asList(1L, 2L, 4L));
        for (Long id: productIds){
            Product product = restTemplate.getForObject("http://localhost/product/"+ id, Product.class);
        }
        return productList;
    }
}
