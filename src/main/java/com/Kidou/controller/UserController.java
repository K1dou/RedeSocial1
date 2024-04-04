package com.Kidou.controller;

import com.Kidou.entities.user.records.UserDTO;
import com.Kidou.entities.user.records.UsersDTO;
import com.Kidou.services.AuthService;
import com.Kidou.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/{name}")
//    @ResponseStatus(HttpStatus.FOUND)
//    public UsersDTO findByName(@PathVariable String name){
//       return userService.findByName(name);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDTO findById(@PathVariable Integer id){
      return  userService.findById(id);
    }











}
