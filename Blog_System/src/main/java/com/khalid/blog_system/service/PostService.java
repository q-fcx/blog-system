package com.khalid.blog_system.service;

import com.khalid.blog_system.model.Category;
import com.khalid.blog_system.model.Post;
import com.khalid.blog_system.model.User;
import com.khalid.blog_system.repository.CategoryRepository;
import com.khalid.blog_system.repository.PostRepository;
import com.khalid.blog_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Boolean addPost(Post post) {
        User user = userRepository.findUserById(post.getUserId());
        Category category = categoryRepository.findCategoryById(post.getCategoryId());
        if(user == null && category == null){
            return false;
        }
        postRepository.save(post);
        return true;
    }

    public Boolean updatePost(Integer id, Post post) {
        Post oldPost = postRepository.findPostById(id);
        if(oldPost == null) {
            return false;
        }
        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());

        postRepository.save(oldPost);
        return true;
    }

    public Boolean deletePost(Integer id) {
        Post post = postRepository.findPostById(id);
        if(post == null) {
            return false;
        }
        postRepository.delete(post);
        return true;
    }

    public List<Post> getPostById(Integer id) {
        return postRepository.findPostByUserId(id);
    }

    public Post getPostByTitle(String title) {
        return postRepository.findPostByTitle(title);
    }

    public List<Post> getPostsByDate(LocalDate date) {
        return postRepository.findPostByDate(date);
    }

    public List<Post> getPostsByUserInCategory(Integer userId, Integer categoryId) {
        return postRepository.findPostsByUserInCategory(userId, categoryId);
    }

    public List<Post> getPostByDateByUser(Integer id, LocalDate date) {
        return postRepository.findPostByDateByUser(id, date);
    }

}
