package com.example.demoProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoProject.model.User;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}