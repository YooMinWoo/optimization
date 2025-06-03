package com.example.optimization.controller;

import com.example.optimization.domain.Post;
import com.example.optimization.repository.PostRepository;
import com.example.optimization.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/optimization")
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping("/dummy")
    public ResponseEntity<?> createDummy(){
        for(int i=1; i<=100000; i++){
            postRepository.save(
                Post.builder()
                        .title("title - "+i)
                        .content("content - "+i)
                        .build()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body("더미데이터 생성 완료");
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getPostList(){
        List<Post> postList = postService.getPostList();
        return ResponseEntity.status(HttpStatus.OK).body(postList);
    }

    @GetMapping("/cache/posts")
    public ResponseEntity<?> getPostListCache(){
        List<Post> postList = postService.getPostListCache();
        return ResponseEntity.status(HttpStatus.OK).body(postList);
    }

}
