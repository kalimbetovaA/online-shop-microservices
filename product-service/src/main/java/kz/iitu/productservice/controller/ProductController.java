package kz.iitu.productservice.controller;

import kz.iitu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
