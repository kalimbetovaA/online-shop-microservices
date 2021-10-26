package kz.iitu.shoppingcartservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.shoppingcartservice.model.Product;
import kz.iitu.shoppingcartservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getProductByIdFallback")
    public Product getProductById(Long productId) {
        Product product = restTemplate.getForObject("http://productservice/products/" + productId, Product.class);
        return  product;
    }

    public Product getProductByIdFallback(Long productId) {
        Product product = new Product();
        product.setName("Product is not available!");
        product.setId(0L);
        return  product;
    }
}
