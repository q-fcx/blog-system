package com.khalid.blog_system.service;

import com.khalid.blog_system.model.Category;
import com.khalid.blog_system.model.Comment;
import com.khalid.blog_system.model.Post;
import com.khalid.blog_system.model.User;
import com.khalid.blog_system.repository.CommentRepository;
import com.khalid.blog_system.repository.PostRepository;
import com.khalid.blog_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public Boolean addComment(Comment comment) {
        User user = userRepository.findUserById(comment.getUserId());
        Post post = postRepository.findPostById(comment.getPostId());

        if(user == null && post == null){
            return false;
        }
        commentRepository.save(comment);
        return true;
    }

    public Boolean updateComment(Integer id, Comment comment) {
        Comment oldComment = commentRepository.findCommentById(id);
        if(oldComment == null) {
            return false;
        }

        oldComment.setContent(comment.getContent());
        oldComment.setCommentDate(comment.getCommentDate());

        commentRepository.save(oldComment);
        return true;
    }

    public Boolean deleteComment(Integer id) {
        Comment comment = commentRepository.findCommentById(id);
        if(comment == null) {
            return false;
        }
        commentRepository.delete(comment);
        return true;
    }

    public List<Comment> getCommentByPostId(Integer id) {
        return commentRepository.findCommentsByPostId(id);
    }

    public List<Comment> getCommentByUserId(Integer id) {
        return commentRepository.findCommentsByUserId(id);
    }
}
