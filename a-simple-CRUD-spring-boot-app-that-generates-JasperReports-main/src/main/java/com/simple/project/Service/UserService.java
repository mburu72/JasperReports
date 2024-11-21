package com.simple.project.Service;

import java.util.List;
import com.simple.project.entity.User;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    User deleteUserByPassword(String password);
    List<User>getAllUsers();

}
