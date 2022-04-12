package com.jonathankim.monster_factory.security;

import com.jonathankim.monster_factory.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}

