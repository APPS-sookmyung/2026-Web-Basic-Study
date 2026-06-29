package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping
    public List<Post> findAll() {
        return postService.findPosts();
    }

    @GetMapping("/{id}")
    public Post findOne(@PathVariable Long id) {
        return postService.findOne(id);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "삭제 완료: id=" + id;
    }
}