package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    // 생성자 주입(DI) 방식 그대로 사용
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public Post findOne(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글 없음 id=" + id));
    }

    public Post update(Long id, Post newData) {
        Post post = findOne(id);
        post.setTitle(newData.getTitle());
        post.setContent(newData.getContent());
        return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}