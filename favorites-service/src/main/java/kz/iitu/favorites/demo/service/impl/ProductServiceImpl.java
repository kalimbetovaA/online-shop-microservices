package kz.iitu.favorites.demo.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.favorites.demo.model.FavProduct;
import kz.iitu.favorites.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getProductByIdFallback",
            threadPoolKey = "getProductById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public FavProduct getProductById(Long productId) {
        FavProduct product = restTemplate.getForObject("http://productservice/products/" + productId, FavProduct.class);
        return  product;
    }

    public FavProduct getProductByIdFallback(Long productId) {
        FavProduct product = new FavProduct();
        product.setName("Product is not available!");
        product.setId(0L);
        return  product;
    }
}
