package com.mp.manage.product.controller.Product;

import com.mp.manage.product.domain.product.Product;
import com.mp.manage.product.domain.dto.ProductDto;
import com.mp.manage.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("product")
    public List<Product> productList(){
        List<Product> products = productService.findProducts();
        return products;
    }

    @GetMapping("product/{name}")
    public Optional<Product> findProductName(@PathVariable String name){
        Optional<Product> product = productService.findByName(name);
        return product;
    }

    @PostMapping("/product/join")
    public ResponseEntity productJoin(@RequestBody ProductDto productDto){
        productService.join(productDto);
        return ResponseEntity.ok().build();
    }
}