package com.techm.CRUDSpring.controller;

import com.techm.CRUDSpring.Model.User;
import com.techm.CRUDSpring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService){
        this.userService= userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.readUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.readUser(id);
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String  deleteUser(@PathVariable long id){
        if(userService.deleteUser(id))
            return "User deleted successfully!!";
        return "User not found";
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
}
