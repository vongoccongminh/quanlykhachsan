package com.httt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailsService {

    public UserDetails loadUserByUsername(String name);

}