package com.simple.project.Controller;

import java.util.List;

import java.util.NoSuchElementException;

import javax.naming.CannotProceedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.project.Service.UserService;
import com.simple.project.entity.User;

@RestController
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping("/user")
    public ResponseEntity<User> createUser(User user) throws CannotProceedException{
        user = service.saveUser(user);

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
        
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
      try{
      User user = service.findUserByUsername(username);
     return new ResponseEntity<User>(user, HttpStatus.OK);

      }  

      catch(NoSuchElementException e){

        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
      }
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
       return service.getAllUsers();
    }

    public ResponseEntity<User>deleteUser(@PathVariable String password){
       try{
        User user = service.deleteUserByPassword(password);
       return new ResponseEntity<User>(user, HttpStatus.GONE);
    }
       catch(NoSuchElementException e){
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
       }
    }
    
}
