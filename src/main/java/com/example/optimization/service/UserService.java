package com.example.optimization.service;

import com.example.optimization.domain.User;
import com.example.optimization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createDummyUser(){
        for(int i=1; i<=10_000; i++){
            userRepository.save(
                    User.builder()
                            .name("user_"+i)
                            .build()
            );
        }
    }
}
