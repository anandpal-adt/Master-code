package com.amazin.nayra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazin.nayra.model.MenuMain;

@Repository
public interface MainMenuRepository extends JpaRepository<MenuMain, Integer>{

//	@Query("From MenuMain ms where ms.commonFields.isDeleted = 0 ")
//	Iterable<MenuMain> findAllpages();
	
	// @Query("From MenuMain ms where ms.commonFields.isDeleted = 0 ")
	

}
