package com.example.optimization.controller;

import com.example.optimization.dto.UserProductStatsDto;
import com.example.optimization.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<?> getUserProductStats(){
        List<UserProductStatsDto> userProductStats = orderService.getUserProductStats();
        return ResponseEntity.status(HttpStatus.OK).body(userProductStats);
    }

    @GetMapping("/orders-cache")
    public ResponseEntity<?> getUserProductStatsByCache(){
        List<UserProductStatsDto> userProductStats = orderService.getUserProductStatsByCache();
        return ResponseEntity.status(HttpStatus.OK).body(userProductStats);
    }
}
