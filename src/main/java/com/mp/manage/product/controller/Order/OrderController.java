package com.mp.manage.product.controller.Order;

import com.mp.manage.product.domain.dto.OrderDto;
import com.mp.manage.product.domain.order.Order;
import com.mp.manage.product.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/join")
    public ResponseEntity joinOrder(@RequestBody OrderDto orderDto) {
        orderService.join(orderDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Order> orderList() {
        List<Order> orders = orderService.findOrders();
        return orders;
    }

    @GetMapping("/{id}")
    public Order findOrder(@PathVariable Long id) {
        Order order = orderService.findOrder(id);
        return order;
    }

    @GetMapping("/member/{id}")
    public List<Order> findMemberOrderList(@PathVariable Long id) {
        List<Order> orders = orderService.findByMemberId(id);
        return orders;
    }

    @GetMapping("/product/{id}")
    public List<Order> findProductOrderList(@PathVariable Long id) {
        List<Order> orders = orderService.findByProductId(id);
        return orders;
    }
}
