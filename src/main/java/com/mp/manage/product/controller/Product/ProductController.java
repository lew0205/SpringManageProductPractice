package com.mp.manage.product.controller.Product;

import com.mp.manage.product.service.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}