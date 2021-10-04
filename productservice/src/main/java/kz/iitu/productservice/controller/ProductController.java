package kz.iitu.productservice.controller;

import kz.iitu.productservice.model.Product;
import kz.iitu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/shop/{shopId}")
    public ResponseEntity<?> getShopProducts(@PathVariable Long shopId){
        return ResponseEntity.ok(productService.getShopProducts(shopId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getCategoryProducts(@PathVariable Long categoryId){
        return ResponseEntity.ok(productService.getCategoryProducts(categoryId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Product product){
        product.setId(id);
        productService.updateProduct(product);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
