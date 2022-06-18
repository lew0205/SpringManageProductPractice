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
public class OrderController {
    private final OrderService orderService;

    @PostMapping("order/join")
    public ResponseEntity joinOrder(@RequestBody OrderDto orderDto) {
        orderService.join(orderDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("order")
    public List<Order> orderList() {
        List<Order> orders = orderService.findOrders();
        return orders;
    }
}
