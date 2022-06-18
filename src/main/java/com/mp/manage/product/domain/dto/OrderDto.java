package com.mp.manage.product.domain.dto;

import com.mp.manage.product.domain.member.Member;
import com.mp.manage.product.domain.order.Order;
import com.mp.manage.product.domain.product.Product;
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
