package com.Kidou.entities.user.records;

import com.Kidou.entities.user.enums.Role;
import com.Kidou.entities.user.enums.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

public record RegisterDTO(String name, @Email String email, @NotBlank(message = "Password obrigatório.") String password, Sexo sexo) {
}


//marcelo@gmail.com senha:admin