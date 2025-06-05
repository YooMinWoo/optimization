package com.example.optimization.dto;

import com.example.optimization.domain.Category;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProductStatsDto {
    private Long userId;
    private String userName;
    private Category category;
    private Long totalOrders;
    private Long totalSpent;
    private Double avgOrderAmount;
}
