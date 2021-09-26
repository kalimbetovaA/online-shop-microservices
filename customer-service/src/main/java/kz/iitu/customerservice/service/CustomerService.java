package kz.iitu.customerservice.service;

import kz.iitu.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAllCustomers();

    public Customer findCustomerById(Long id);

    public void createCustomer(Customer customer);

    public void deleteCustomer(Long id);

    public void updateCustomer(Customer customer);
}
