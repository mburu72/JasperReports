package com.simple.project.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.project.Repository.UserDao;
import com.simple.project.entity.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
 private UserDao userDao;
 
    @Override
    public User saveUser(User user) {
      userDao.save(user);
      return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User deleteUserByPassword(String password) {
        userDao.deleteUserByPassword(password);
        return null;
    }

    @Override
    public List<User> getAllUsers(){
    return userDao.findAll();
    }


  
    
}
