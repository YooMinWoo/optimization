package com.example.optimization;

import com.example.optimization.domain.Post;
import com.example.optimization.repository.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class OptimizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimizationApplication.class, args);
	}

}
