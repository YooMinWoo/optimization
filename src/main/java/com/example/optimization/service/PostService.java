package com.example.optimization.service;

import com.example.optimization.domain.Post;
import com.example.optimization.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPostList() {
        return postRepository.findAll();
    }

    @Cacheable(value = "test")
    public List<Post> getPostListCache() {
        return postRepository.findAll();
    }

}
