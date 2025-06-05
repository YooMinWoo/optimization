package com.example.optimization.controller;

import com.example.optimization.service.OrderService;
import com.example.optimization.service.ProductService;
import com.example.optimization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dummy")
public class DummyController {

    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<?> createDummyOrders(){
        orderService.createDummyOrders();
        return ResponseEntity.status(HttpStatus.OK).body("더미데이터 생성 완료");
    }

    @PostMapping("/users")
    public ResponseEntity<?> createDummyUser(){
        userService.createDummyUser();
        return ResponseEntity.status(HttpStatus.OK).body("더미데이터 생성 완료");
    }

    @PostMapping("/products")
    public ResponseEntity<?> createDummyProduct(){
        productService.createDummyProduct();
        return ResponseEntity.status(HttpStatus.OK).body("더미데이터 생성 완료");
    }
}
