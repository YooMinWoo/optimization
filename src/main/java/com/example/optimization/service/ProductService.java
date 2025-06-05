package com.example.optimization.service;

import com.example.optimization.domain.Category;
import com.example.optimization.domain.Product;
import com.example.optimization.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void createDummyProduct(){
        for(int i=1; i<=100_000; i++){
            productRepository.save(
                    Product.builder()
                            .name("product_"+i)
                            .category(getRandomCategory())
                            .build()
            );
        }
    }

    private Category getRandomCategory(){
        Random random = new Random();
        Category[] values = Category.values();
        return values[random.nextInt(5)];
    }
}
