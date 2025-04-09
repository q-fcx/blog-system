package com.khalid.blog_system.controller;

import com.khalid.blog_system.model.Post;
import com.khalid.blog_system.model.User;
import com.khalid.blog_system.service.PostService;
import com.khalid.blog_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getAllPosts() {
        return ResponseEntity.status(200).body(postService.getAllPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isAdded = postService.addPost(post);
        if (isAdded) {
            return ResponseEntity.status(400).body("post added");
        }

        return ResponseEntity.status(400).body("id not found");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        Boolean isUpdated = postService.updatePost(id, post);
        if (isUpdated) {
            return ResponseEntity.status(200).body("post updated");
        }
        return ResponseEntity.status(400).body("Id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id) {
        Boolean isDeleted = postService.deletePost(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("post deleted");
        }
        return ResponseEntity.status(400).body("Id not found");
    }

    @GetMapping("/get-userid/{id}")
    public ResponseEntity getPostByUserId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(postService.getPostById(id));
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title) {
        return ResponseEntity.status(200).body(postService.getPostByTitle(title));
    }

    @GetMapping("/get-date/{date}")
    public ResponseEntity getPostByDate(@PathVariable LocalDate date) {
        return ResponseEntity.status(200).body(postService.getPostsByDate(date));
    }

    @GetMapping("/get-category/{userId}/{categoryId}")
    public ResponseEntity getPostByUserInCategory(@PathVariable Integer userId, @PathVariable Integer categoryId) {
        return ResponseEntity.status(200).body(postService.getPostsByUserInCategory(userId,categoryId));
    }

    @GetMapping("get-id-date/{id}/{date}")
    public ResponseEntity getPostsByDateByUser(@PathVariable Integer id, @PathVariable LocalDate date) {
        return ResponseEntity.status(200).body(postService.getPostByDateByUser(id, date));
    }
}
