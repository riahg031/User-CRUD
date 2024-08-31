package com.techm.CRUDSpring.service;

import com.techm.CRUDSpring.Model.User;

import java.util.List;

public interface UserService {

    String createUser(User user);
    List<User> readUsers();
    User readUser(long id);
    boolean deleteUser(long id);
    String updateUser(long id, User user);

}
