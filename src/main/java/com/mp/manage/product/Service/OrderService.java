package com.mp.manage.product.Service;

import com.mp.manage.product.Repository.MemberRepository;
import com.mp.manage.product.Repository.OrderRepository;
import com.mp.manage.product.Repository.ProductRepository;
import com.mp.manage.product.domain.Member;
import com.mp.manage.product.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class OrderService {
    private OrderRepository orderRepository;
    private MemberRepository memberRepository;
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

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