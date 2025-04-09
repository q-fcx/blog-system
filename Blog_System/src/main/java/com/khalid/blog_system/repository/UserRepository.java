package com.khalid.blog_system.repository;

import com.khalid.blog_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    // 7. find users registers before date by date
    @Query("select u from User u where u.registrationDate<?1")
    List<User> findUsersByDate(LocalDate date);
}
