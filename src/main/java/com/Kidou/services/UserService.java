package com.Kidou.services;

import com.Kidou.entities.user.Users;
import com.Kidou.entities.user.records.UsersDTO;
import com.Kidou.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UsersDTO findByName (String name){
       Users u =  userRepository.findByName(name);
       UsersDTO dto = new UsersDTO(u.getName(),u.getEmail(),u.getSexo());
       return dto;
    }







}
