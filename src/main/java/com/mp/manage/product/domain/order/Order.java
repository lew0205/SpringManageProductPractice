package com.mp.manage.product.domain.order;

import com.mp.manage.product.domain.product.Product;
import com.mp.manage.product.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Long productNum;
}