package com.webservices.restfulwebservices.controller;

import com.webservices.restfulwebservices.models.User;
import com.webservices.restfulwebservices.services.UserService;
import com.webservices.restfulwebservices.services.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/users"})
public class UserController {
    private UserService _service;

    public UserController(UserService _service) {
        this._service = _service;
    }

    @GetMapping
    public List<User> getUsers(){
        return _service.getAllUsers();
    }

    @GetMapping({"{Id}"})
    public User findUser(@PathVariable("Id") Long Id){
            return _service.getUserById(Id);
    }

     @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity(_service.createUser(user), HttpStatus.CREATED);
    }


    @DeleteMapping({"{Id}"})
    public ResponseEntity<String> DeleteUser(@PathVariable("Id") Long Id){
        _service.deleteUser(Id);
        return new ResponseEntity<String>("User Successfully Deleted", HttpStatus.OK);
    }
}
