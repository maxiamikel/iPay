package com.maxi.iPayback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.iPayback.entities.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // @Query("SELECT u FROM User u WHERE u.personalId = :personalId ")
    User findByPersonalId(String personalId);

    Optional<User> findById(Long id);
}
