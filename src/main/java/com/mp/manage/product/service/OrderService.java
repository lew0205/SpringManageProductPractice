package com.mp.manage.product.service;

import com.mp.manage.product.repository.MemberRepository;
import com.mp.manage.product.repository.OrderRepository;
import com.mp.manage.product.repository.ProductRepository;
import com.mp.manage.product.domain.order.Order;
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

    public Long joinOrder(Order order) {
        orderRepository.save(order);
        return order.getId();
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