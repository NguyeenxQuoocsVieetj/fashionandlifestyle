package org.example.fashionandlifestyle.repository;

import org.example.fashionandlifestyle.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findUsersByEmail(String email);
}
