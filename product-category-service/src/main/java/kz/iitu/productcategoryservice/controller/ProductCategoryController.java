package kz.iitu.productcategoryservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.productcategoryservice.model.ProductCategory;
import kz.iitu.productcategoryservice.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-categories")
@Api(value = "Product Category Controller", description = "Controller allows to interact with ProductCategory object")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @ApiOperation(value = "To get all Product Categories from the database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("")
    public ResponseEntity<?> getAllProductCategories() {
        return ResponseEntity.ok(productCategoryService.findAllCategories());
    }

    @ApiOperation(value = "To get information about specific Product Category by its Id", response = ProductCategory.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved ProductCategory object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.findProductCategoryById(id));
    }

    @ApiOperation(value = "To get all products assigned to specific Product Category", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Products list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}/products")
    public ResponseEntity<?> getCategoryProducts(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.getAllProducts(id));
    }


    @ApiOperation(value = "Method to Create a new Product Category in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("")
    public ResponseEntity<?> addProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.addProductCategory(productCategory);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Method to Delete a Product Category by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "Method to Update Product Category by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductCategory(@PathVariable Long id, @RequestBody ProductCategory productCategory) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
