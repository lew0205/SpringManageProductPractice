package com.mp.manage.product.controller.Product;

import com.mp.manage.product.domain.product.Product;
import com.mp.manage.product.domain.dto.ProductDto;
import com.mp.manage.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("product/list")
    public List<Product> productList(){
        List<Product> products = productService.findProducts();
        return products;
    }

    @PostMapping("/product")
    public void productJoin(@RequestBody ProductDto productDto){

    }
}