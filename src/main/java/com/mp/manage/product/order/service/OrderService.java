package com.mp.manage.product.order.service;

import com.mp.manage.product.order.dto.OrderDto;
import com.mp.manage.product.member.Member;
import com.mp.manage.product.product.Product;
import com.mp.manage.product.member.repository.MemberRepository;
import com.mp.manage.product.order.repository.OrderRepository;
import com.mp.manage.product.product.repository.ProductRepository;
import com.mp.manage.product.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    public Long join(OrderDto orderDto) {
        Member member = memberRepository.findById(orderDto.getMember())
                .orElseThrow(() -> new RuntimeException());
        Product product = productRepository.findById(orderDto.getProduct())
                .orElseThrow(() -> new RuntimeException());
        Order order = orderDto.toEntity(member, product);
        return orderRepository.save(order).getId();
    }

    public List<Order> findOrders() {
        return orderRepository.findAll();
    }

    public Order findOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Order> findByMemberId(Long id) {
        return orderRepository.findAllByMember_Id(id);
    }

    public List<Order> findByMemberName(String name) {
        return orderRepository.findAllByMember_Name(name);
    }

    public List<Order> findByProductName(String name) {
        return orderRepository.findAllByProduct_Name(name);
    }

    public List<Order> findByProductId(Long id) {
        return orderRepository.findAllByProduct_Id(id);
    }
}