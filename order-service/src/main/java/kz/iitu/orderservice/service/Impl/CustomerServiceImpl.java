package kz.iitu.orderservice.service.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.orderservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getCustomerAddressFallback",
            threadPoolKey = "getCustomerAddress",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public String getCustomerAddress(Long customerId) {
        return restTemplate.getForObject("http://customer-service/customers/"+customerId+"/address", String.class);
    }

    public String getCustomerAddressFallback(Long customerId) {
        return "Customer Address is not available: Service Unavailable";
    }
}
