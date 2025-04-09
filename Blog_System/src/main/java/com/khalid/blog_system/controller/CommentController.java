package com.khalid.blog_system.controller;

import com.khalid.blog_system.model.Comment;
import com.khalid.blog_system.model.Post;
import com.khalid.blog_system.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity getAllComments() {
        return ResponseEntity.status(200).body(commentService.getAllComment());
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isAdded = commentService.addComment(comment);
        if(isAdded) {
            return ResponseEntity.status(400).body("comment added");
        }

        return ResponseEntity.status(400).body("id not found");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        Boolean isUpdated = commentService.updateComment(id, comment);
        if(isUpdated) {
            return ResponseEntity.status(200).body("comment updated");
        }
        return ResponseEntity.status(400).body("Id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id) {
        Boolean isDeleted = commentService.deleteComment(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("comment deleted");
        }
        return ResponseEntity.status(400).body("Id not found");
    }

    @GetMapping("/get-post/{id}")
    public ResponseEntity getCommentByPostId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(commentService.getCommentByPostId(id));
    }

    @GetMapping("get-comment/{id}")
    public ResponseEntity getCommentByUserId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(commentService.getCommentByUserId(id));
    }

    @DeleteMapping("/delete-comment/{userId}/{postId}/{commentId}")
    public ResponseEntity deleteCommentByUserIdAndPostId(@PathVariable Integer userId, @PathVariable Integer postId, @PathVariable Integer commentId) {
        Boolean isDeleted = commentService.deleteCommentByUserIdAndPostId(userId,postId,commentId);
        if(isDeleted) {
            return ResponseEntity.status(200).body("Comment in the post deleted");
        }
        return ResponseEntity.status(400).body("id not found");
    }
}
