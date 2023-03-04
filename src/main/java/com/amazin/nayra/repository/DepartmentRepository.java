package com.amazin.nayra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazin.nayra.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	//Optional<Department> findBydepartmentName(String departmentName);

}
