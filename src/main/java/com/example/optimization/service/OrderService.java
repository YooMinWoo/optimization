package com.example.optimization.service;

import com.example.optimization.domain.Order;
import com.example.optimization.dto.UserProductStatsDto;
import com.example.optimization.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Cacheable(value = "getUserProductStats")
    public List<UserProductStatsDto> getUserProductStatsByCache(){
        return orderRepository.getUserProductStats();
    }

    public List<UserProductStatsDto> getUserProductStats(){
        return orderRepository.getUserProductStats();
    }

    @Transactional
    public void createDummyOrders(){
        Random random = new Random();
        for(int i=1; i<=500_000; i++){
            orderRepository.save(
                    Order.builder()
                            .userId(random.nextLong(10000)+1)
                            .productId(random.nextLong(100000)+1)
                            .totalAmount(random.nextLong(10)+1)
                            .orderDate(getRandomDate())
                            .build()
            );
        }
    }

    public static LocalDate getRandomDate() {
        Random random = new Random();
        LocalDate start = LocalDate.of(2025,1,1);
        LocalDate end = LocalDate.of(2025,6,1);
        long days = ChronoUnit.DAYS.between(start, end);
        long randomDays = random.nextLong(days + 1);
        return start.plusDays(randomDays);
    }
}
