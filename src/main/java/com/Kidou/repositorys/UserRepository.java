package com.Kidou.repositorys;


import com.Kidou.entities.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users,Integer> {

    UserDetails findByEmail(String email);
}
