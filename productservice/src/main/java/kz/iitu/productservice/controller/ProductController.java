package kz.iitu.productservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.productservice.model.Product;
import kz.iitu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Api(value = "Product Controller", description = "Controller allows to interact with Product object")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "To get all Products from the database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @ApiOperation(value = "To get all Products of specific Shop", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<?> getShopProducts(@PathVariable Long shopId){
        return ResponseEntity.ok(productService.getShopProducts(shopId));
    }

    @ApiOperation(value = "To get all Products of specific Category", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getCategoryProducts(@PathVariable Long categoryId){
        return ResponseEntity.ok(productService.getCategoryProducts(categoryId));
    }


    @ApiOperation(value = "To get information about specific Product by its Id", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Product object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @ApiOperation(value = "Method to Create a new Product in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Method to Delete Product by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "Method to Update Product by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Product product){
        product.setId(id);
        productService.updateProduct(product);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
