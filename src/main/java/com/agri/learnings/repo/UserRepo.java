package com.agri.learnings.repo;

import com.agri.learnings.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

    Optional<Users> findByEmail(String email);
}
