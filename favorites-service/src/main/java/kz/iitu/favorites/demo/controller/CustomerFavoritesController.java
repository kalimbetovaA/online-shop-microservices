package kz.iitu.favorites.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.favorites.demo.model.CustomerFavorites;
import kz.iitu.favorites.demo.service.CustomerFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fav")
public class CustomerFavoritesController {
    @Autowired
    private CustomerFavoritesService customerFavoritesService;


    @ApiOperation(value = "To get Cart info of specific Customer by its Id", response = CustomerFavorites.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Cart object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomerFavorites(@PathVariable Long customerId){
        CustomerFavorites customerFavorites = customerFavoritesService.getCustomerFavorites(customerId);
        return ResponseEntity.ok(customerFavorites);
    }

    @ApiOperation(value = "Method to add a new Favorite Products for specific Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("/customer/{customerId}/add")
    public ResponseEntity<?> addToFav(@PathVariable Long customerId, @RequestParam Long productId){
        customerFavoritesService.addToFav(customerId, productId);
        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }


    @ApiOperation(value = "Method to remove a new Favorite Products for specific Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("/customer/{customerId}/remove")
    public ResponseEntity<?> removeFromFav(@PathVariable Long customerId, @RequestParam Long productId){
        customerFavoritesService.removeFromFav(customerId, productId);
        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }


    @ApiOperation(value = "Method to Update Favorite Products by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomerFavorites(@PathVariable Long id,@RequestBody CustomerFavorites customerFavorites){
        customerFavorites.setId(id);
        customerFavoritesService.updateCustomerFavorites(customerFavorites);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
