package com.agri.learnings.service;

import com.agri.learnings.entity.UserPrinciple;
import com.agri.learnings.exception.CustomUserNotFoundException;
import com.agri.learnings.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    UserRepo userRepo;

    @Autowired
    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepo.findByUsername(username))
                .map(UserPrinciple::new)
                .orElseThrow(() -> {
                    log.error("User Not Found");
                    return new CustomUserNotFoundException("User not found");
                });
    }
}
