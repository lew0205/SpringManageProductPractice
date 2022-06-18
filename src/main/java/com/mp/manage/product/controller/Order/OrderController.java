package com.mp.manage.product.controller.Order;

import com.mp.manage.product.domain.dto.OrderDto;
import com.mp.manage.product.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    public ResponseEntity joinOrder(@RequestBody OrderDto orderDto) {
        orderService.join(orderDto);
        return ResponseEntity.ok().build();
    }
}
