package com.mp.manage.product.product.dto;

import com.mp.manage.product.product.Product;
import lombok.Getter;

@Getter
public class ProductDto {
    private String name;
    private Long price;

    public Product toEntity(){
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .build();
    }
}
