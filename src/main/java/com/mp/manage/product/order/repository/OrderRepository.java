package com.mp.manage.product.order.repository;

import com.mp.manage.product.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrder(Long id);

    List<Order> findAllByMember_Name(String name);

    List<Order> findAllByMember_Id(Long id);

    List<Order> findAllByProduct_Id(Long id);

    List<Order> findAllByProduct_Name(String name);
}
