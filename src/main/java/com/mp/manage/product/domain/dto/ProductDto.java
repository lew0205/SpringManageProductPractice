package com.mp.manage.product.domain.dto;

import com.mp.manage.product.domain.product.Product;
import lombok.Getter;

import javax.persistence.Column;

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
