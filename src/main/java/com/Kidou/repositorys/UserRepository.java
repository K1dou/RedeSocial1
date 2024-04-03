package com.Kidou.repositorys;


import com.Kidou.entities.user.Users;
import com.Kidou.entities.user.records.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, Integer> {


    @Query("SELECT u FROM Users u WHERE u.email =:email")
    Users findByEmail(@Param("email") String email);


    @Query("SELECT u FROM Users u WHERE u.name =:name")
    Users findByName(@Param("name") String name);

}
