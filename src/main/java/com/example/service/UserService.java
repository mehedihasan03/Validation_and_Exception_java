package com.example.service;

import com.example.dto.UserRequest;
import com.example.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(
                0,
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality()
        );
        return repository.save(user);
    }

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public User GetUserByUserId(Long id) throws UserNotFoundException {
        User user = repository.findByUserId(id);

        if ( user!= null ){
            return user;
        } else {
            throw new UserNotFoundException("User not found with this UserId : " + id);
        }
    }
}
