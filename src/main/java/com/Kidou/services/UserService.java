package com.Kidou.services;

import com.Kidou.entities.user.Users;
import com.Kidou.entities.user.records.UserDTO;
import com.Kidou.entities.user.records.UsersDTO;
import com.Kidou.exceptions.NotFoundException;
import com.Kidou.repositorys.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    public UserDTO findById (Integer id){
       Users u = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Id do usuário não encontrado."));
        return new UserDTO(u.getName(),u.getEmail(),u.getPassword(),u.getSexo(),u.getRole());
    }







}
