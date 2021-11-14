package kz.iitu.authservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.authservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUsersFallback",
            threadPoolKey = "getUsers",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public List<Customer> getUsers() {
        List<Customer> customerList = restTemplate.getForObject("http://customer-service/customers/getAll",  List.class);
        return customerList;
    }

    public List<Customer> getUsersFallback() {
        List<Customer> customerList  = new ArrayList<Customer>();
        return customerList;
    }
}
