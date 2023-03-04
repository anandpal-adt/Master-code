package com.amazin.nayra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amazin.nayra.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	@Query(value = "select * from users where email=:email", nativeQuery = true)
	Users findByEmail(@Param("email")String email);

	@Query(value = "select * from users where username=:username", nativeQuery = true)
	Users findByUserName(@Param("username")String username);

	Users findByContact(String contact);

//	@Query(value = "select * from users where access_token=:accssToken",nativeQuery = true)
//	public Users findUsersDetailsByRemoteIP(@Param("accssToken") String accssToken);

//	@Query("SELECT u from Users u where  u.email=?1 and u.active=true")
//	public Users findByEmail(String email);

//	@Query("SELECT u from Users u where  u.Contact=?1 and u.active=true")
//	public Users findByContact(String phoneNo);
	
	
}
