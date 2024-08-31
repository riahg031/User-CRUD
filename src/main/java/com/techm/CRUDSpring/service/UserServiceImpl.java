package com.techm.CRUDSpring.service;

import com.techm.CRUDSpring.Entity.UserEntity;
import com.techm.CRUDSpring.Model.User;
import com.techm.CRUDSpring.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public String createUser(User user){
        UserEntity userEntity= new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return "User saved successfully!!";
    }

    @Override
    public List<User> readUsers(){
        List<UserEntity> userList= userRepository.findAll();
        List<User> users= new ArrayList<>();
        for(UserEntity userEntity: userList){
            User user1= new User();
            user1.setId(userEntity.getId());
            user1.setName(userEntity.getName());
            user1.setPhone(userEntity.getPhone());
            user1.setEmail(userEntity.getEmail());
            users.add(user1);
        }
        return users;
    }

    @Override
    public User readUser(long id){
        UserEntity userEntity= userRepository.findById(id).get();
        User user= new User();
       BeanUtils.copyProperties(userEntity, user);
       return user;
    }

    @Override
    public boolean deleteUser(long id){
        UserEntity userEntity= userRepository.findById(id).get();
        userRepository.delete(userEntity);
        return true;
    }

    @Override
    public String updateUser(long id, User user){
        UserEntity existingUser= userRepository.findById(id).get();
        existingUser.setName(user.getName());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return "User updated successfully!!";
    }
}
