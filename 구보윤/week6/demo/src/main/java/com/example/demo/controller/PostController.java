package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.dto.PostResponseDto;
import com.example.demo.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> create(@Valid @RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return ResponseEntity.ok(PostResponseDto.from(savedPost));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> findAll() {
        List<PostResponseDto> posts = postService.findPosts().stream()
                .map(PostResponseDto::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> findOne(@PathVariable Long id) {
        Post post = postService.findOne(id);
        return ResponseEntity.ok(PostResponseDto.from(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> update(@PathVariable Long id, @Valid @RequestBody Post post) {
        Post updatedPost = postService.update(id, post);
        return ResponseEntity.ok(PostResponseDto.from(updatedPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok("삭제 완료: id=" + id);
    }
}