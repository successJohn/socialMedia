package com.webservices.restfulwebservices.services.impl;

import com.webservices.restfulwebservices.customException.ResourceNotFoundException;
import com.webservices.restfulwebservices.models.User;
import com.webservices.restfulwebservices.repository.UserRepository;
import com.webservices.restfulwebservices.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository _userRepository;

    public UserServiceImpl(UserRepository _userRepository) {
        this._userRepository = _userRepository;
    }

    public List<User> getAllUsers(){
        return _userRepository.findAll();
    }

    public User getUserById(Long Id){
        return _userRepository.findById(Id).orElseThrow(()->{
            return new ResourceNotFoundException("User", "Id", Id);
        });
    }

    public User createUser(User user){
        return _userRepository.save(user);
    }

    public void deleteUser(Long Id){
        User existingUser = _userRepository.findById(Id).orElseThrow(() -> {
            return new ResourceNotFoundException("Employee","Id",Id);
        });

        _userRepository.deleteById(Id);
    }
}
