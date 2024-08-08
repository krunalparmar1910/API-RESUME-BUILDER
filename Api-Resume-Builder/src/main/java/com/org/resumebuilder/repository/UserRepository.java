package com.org.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.resumebuilder.model.LoginUser;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Long> {
	Optional<LoginUser> findByUsername(String username);

}
