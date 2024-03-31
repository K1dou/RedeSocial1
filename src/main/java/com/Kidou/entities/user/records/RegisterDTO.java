package com.Kidou.entities.user.records;

import com.Kidou.entities.user.enums.Role;
import com.Kidou.entities.user.enums.Sexo;

public record RegisterDTO(String name, String email, String password, Sexo sexo, Role role) {
}
