package com.harshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshit.model.loginclass.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
