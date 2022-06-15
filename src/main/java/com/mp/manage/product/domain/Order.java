package com.mp.manage.product.domain;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "m_id",nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "p_id",nullable = false)
    private Product product;

    @Column(nullable = false)
    private Long productNum;
}