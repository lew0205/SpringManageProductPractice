package com.mp.manage.product.product.controller;

import com.mp.manage.product.product.Product;
import com.mp.manage.product.product.dto.ProductDto;
import com.mp.manage.product.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> productList(){
        List<Product> products = productService.findProducts();
        return products;
    }

    @GetMapping("/{name}")
    public Product findProductName(@PathVariable String name){
        Product product = productService.findByName(name);
        return product;
    }

    @PostMapping("/join")
    public ResponseEntity productJoin(@RequestBody ProductDto productDto){
        productService.join(productDto);
        return ResponseEntity.ok().build();
    }
}