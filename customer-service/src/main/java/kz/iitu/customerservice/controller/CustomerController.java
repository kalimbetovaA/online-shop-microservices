package kz.iitu.customerservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.customerservice.model.Customer;
import kz.iitu.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/customers")
@Api(value = "Customer Controller", description = "Controller allows to interact with Customer object")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "To get all Customers from the database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @ApiOperation(value = "To get information about specific Customer by its Id", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Customer object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }


    @ApiOperation(value = "To get username of Customer by its Id", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Customer username"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}/username")
    public ResponseEntity<?> getUsernameByCustomerId(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomerUsernameById(id));
    }

    @ApiOperation(value = "To get address of Customer by its Id", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Customer address"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}/address")
    public ResponseEntity<?> getAddressByCustomerId(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomerAddressById(id));
    }

    @ApiOperation(value = "Method to Create a new Customer in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Method to Delete a Customer by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "Method to Update Customer by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        customerService.updateCustomer(customer);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
