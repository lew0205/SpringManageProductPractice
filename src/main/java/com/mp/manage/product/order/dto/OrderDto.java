package com.mp.manage.product.order.dto;

import com.mp.manage.product.member.Member;
import com.mp.manage.product.order.Order;
import com.mp.manage.product.product.Product;
import lombok.Getter;

@Getter
public class OrderDto {
    private Long member;
    private Long product;
    private Long productCnt;


    public Order toEntity(Member member,Product product) {
        return Order.builder()
                .member(member)
                .product(product)
                .productCnt(this.productCnt)
                .build();
    }
}
