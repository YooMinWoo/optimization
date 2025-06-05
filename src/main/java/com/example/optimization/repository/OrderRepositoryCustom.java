package com.example.optimization.repository;

import com.example.optimization.dto.UserProductStatsDto;

import java.util.List;

public interface OrderRepositoryCustom {
    List<UserProductStatsDto> getUserProductStats();
}
