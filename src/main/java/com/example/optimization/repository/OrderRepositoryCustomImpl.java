package com.example.optimization.repository;

import com.example.optimization.domain.Category;
import com.example.optimization.domain.QOrder;
import com.example.optimization.domain.QProduct;
import com.example.optimization.domain.QUser;
import com.example.optimization.dto.UserProductStatsDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<UserProductStatsDto> getUserProductStats() {
        QProduct product = QProduct.product;
        QUser user = QUser.user;
        QOrder order = QOrder.order;

        return queryFactory
                .select(Projections.constructor(
                        UserProductStatsDto.class,
                        user.id,
                        user.name,
                        product.category,
                        order.count(),
                        order.totalAmount.sum(),
                        order.totalAmount.avg()
                ))
                .from(order)
                .join(user).on(order.userId.eq(user.id))
                .join(product).on(order.productId.eq(product.id))
                .where(
                        user.name.contains("user_4"),
                        order.orderDate.between(
                                LocalDate.of(2025, 1, 1),
                                LocalDate.of(2025, 6, 1)
                        )
                )
                .groupBy(user.id, product.category)
                .having(order.totalAmount.count().gt(5))
                .orderBy(order.totalAmount.sum().desc(), user.name.asc())
                .limit(20)
                .fetch();
    }
}
