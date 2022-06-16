package com.mp.manage.product.domain.dto;

import com.mp.manage.product.domain.member.Member;
import com.mp.manage.product.domain.order.Order;
import com.mp.manage.product.domain.product.Product;
import lombok.Getter;

@Getter
public class OrderDto {
    private Member member;
    private Product product;
    private Long productCnt;


    public Order toEntity() {
        return Order.builder()
                .member(this.member)
                .product(this.product)
                .productCnt(this.productCnt)
                .build();
    }
}
