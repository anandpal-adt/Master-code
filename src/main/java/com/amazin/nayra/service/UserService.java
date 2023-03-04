package com.amazin.nayra.service;

import com.amazin.nayra.common.DataContainer;
import com.amazin.nayra.model.MenuMain;
import com.amazin.nayra.model.Users;
import com.amazin.nayra.request.UserRequest;


public interface UserService {

	Users userRegister(UserRequest str, Integer id);

	//boolean forgotPassword(String email);

	//Users changePassword(Integer integer, String oldPassword, String newPassword);

	DataContainer forgetPassword(String email);


	Users findByEmail(String email);

	 Users findByUserName(String username);

	Iterable<MenuMain> findAllpages();

	
	
	
	
	

//	ResponseEntity<Users> addUsers(Users users);
//
//	void getUpdateSession(HttpServletRequest httpServletRequest);
	


}
