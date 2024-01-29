package com.harshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshit.model.loginclass.User;


@Repository
public interface UserRespository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
