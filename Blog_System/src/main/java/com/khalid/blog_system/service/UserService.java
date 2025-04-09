package com.khalid.blog_system.service;

import com.khalid.blog_system.model.User;
import com.khalid.blog_system.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user) {
        User oldUser = userRepository.findUserById(id);
        if(oldUser == null) {
            return false;
        }

        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setRegistration_date(user.getRegistration_date());

        userRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id) {
        User user = userRepository.findUserById(id);
        if(user == null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }

    public List<User> getUsersByDate(LocalDate date) {
        return userRepository.findUsersByDate(date);
    }
}
