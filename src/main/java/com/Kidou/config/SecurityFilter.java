package com.Kidou.config;

import com.Kidou.entities.user.Users;
import com.Kidou.repositorys.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    //request é o token
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recoverToken(request);

        if (token != null) {
            System.out.println("Token: " + token);

            //esta chegando nulo
            String login = tokenService.validateToken(token);
            System.out.println("Login: " + login);


            if (login != null) {
                Users user = userRepository.findByEmail(login);

                if (user != null) {
                    var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());


                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    System.out.println("User is null");
                }
            } else {
                System.out.println("Login is null");
            }
        }
        filterChain.doFilter(request, response);

    }

    //recorta o Bearer do token
    private String recoverToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.replace("Bearer ", "");
        } else {
            return null;
        }

    }


}