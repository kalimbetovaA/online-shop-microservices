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

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductInformationById(@PathVariable Long id) {

        return ResponseEntity.ok(productService.getProductInformationById(id));
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> getProductInformationByName(@PathVariable String name) {

        return ResponseEntity.ok(productService.getProductInformationByName(name));
    }
    @PostMapping("")
    public ResponseEntity<?> createProduct(@PathVariable Product product){
        productService.createProduct(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@PathVariable Product product){
        product.setId(id);
        productService.updateProduct(product);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
