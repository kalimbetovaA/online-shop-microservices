package kz.iitu.productcategoryservice.controller;

import kz.iitu.productcategoryservice.model.ProductCategory;
import kz.iitu.productcategoryservice.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllProductCategories() {
        return ResponseEntity.ok(productCategoryService.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.findProductCategoryById(id));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> getCategoryProducts(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.getAllProducts(id));
    }


    @PostMapping("")
    public ResponseEntity<?> addProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.addProductCategory(productCategory);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductCategory(@PathVariable Long id, @RequestBody ProductCategory productCategory) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
