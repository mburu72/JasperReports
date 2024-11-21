package com.simple.project.Repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.simple.project.entity.User;


public interface UserDao extends JpaRepository<User, Integer>{
    User findUserByUsername(String username);
    User deleteUserByPassword(String password);
  

}
