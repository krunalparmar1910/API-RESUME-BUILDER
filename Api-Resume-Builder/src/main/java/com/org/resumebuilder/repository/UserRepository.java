package com.org.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.resumebuilder.security.LoginUser;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Long> {

	// for Login User
	Optional<LoginUser> findByUsername(String username);

	Optional<LoginUser> findByEmail(String username);

	// for register user if exist or not!!
	boolean existsByMobile(String mobile);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
