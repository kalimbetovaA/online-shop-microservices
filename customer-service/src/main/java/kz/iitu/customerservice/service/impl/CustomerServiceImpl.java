package kz.iitu.customerservice.service.impl;

import kz.iitu.customerservice.model.Customer;
import kz.iitu.customerservice.repository.CustomerRepository;
import kz.iitu.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public String findCustomerUsernameById(Long id) {
        return customerRepository.findById(id).get().getUsername();
    }

    @Override
    public String findCustomerAddressById(Long id) {
        return customerRepository.findById(id).get().getAddress();
    }

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createCustomer(Customer customer) {
//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            customerRepository.deleteById(id);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());

        if (customerOptional.isPresent()) {
            Customer dbCustomer = customerOptional.get();
            dbCustomer.setUsername(customer.getUsername());
            dbCustomer.setFirstname(customer.getFirstname());
            dbCustomer.setLastname(customer.getLastname());
            dbCustomer.setEmail(customer.getEmail());
            dbCustomer.setAddress(customer.getAddress());
            dbCustomer.setWallet(customer.getWallet());
            dbCustomer.setPassword(customer.getPassword());
            customerRepository.saveAndFlush(dbCustomer);
        }
    }


}
