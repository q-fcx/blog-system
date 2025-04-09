package com.khalid.blog_system.repository;

import com.khalid.blog_system.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findCommentById(Integer id);

    // 4
    List<Comment> findCommentsByPostId(Integer id);

    // 8. find all comment by user
    List<Comment> findCommentsByUserId(Integer id);

}
