package com.khalid.blog_system.repository;

import com.khalid.blog_system.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostById(Integer id);

    List<Post> findPostByUserId(Integer id);

    Post findPostByTitle(String title);

    @Query("select p from Post p where p.publishDate<?1")
    List<Post> findPostByDate(LocalDate date);

    // find posts by user in a category
    @Query("select p from Post p where p.userId=?1 and p.categoryId=?2")
    List<Post> findPostsByUserInCategory(Integer userId, Integer categoryId );

    // find posts for user by date
    @Query("select p from Post p where p.userId=?1 and p.publishDate=?2")
    List<Post> findPostByDateByUser(Integer id, LocalDate date);


}
