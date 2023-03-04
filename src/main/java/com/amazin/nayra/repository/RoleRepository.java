package com.amazin.nayra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazin.nayra.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRoleName(String role);

}
