package kz.iitu.productcategoryservice.controller;

import kz.iitu.productcategoryservice.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;
}
