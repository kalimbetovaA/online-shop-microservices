package kz.iitu.shopservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.shopservice.model.Shop;
import kz.iitu.shopservice.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @ApiOperation(value = "To get all Shops from the database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("")
    public ResponseEntity<?> getAllShops() {
        return ResponseEntity.ok(shopService.findAllShops());
    }

    @ApiOperation(value = "To get information about specific Shop by its Id", response = Shop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Shop object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getShopById(@PathVariable Long id) {
        return ResponseEntity.ok(shopService.findShopById(id));
    }

    @ApiOperation(value = "To get all Products of specific Shop by its Id", response = Shop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Product list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}/products")
    public ResponseEntity<?> getShopProducts(@PathVariable Long id) {
        return ResponseEntity.ok(shopService.getShopProducts(id));
    }

    @ApiOperation(value = "Method to Create a new Shop in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("")
    public ResponseEntity<?> addShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Method to Delete an Shop by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "Method to Update Shop by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        shop.setId(id);
        shopService.updateShop(shop);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
