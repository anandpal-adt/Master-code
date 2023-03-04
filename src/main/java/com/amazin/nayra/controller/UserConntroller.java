package com.amazin.nayra.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazin.nayra.common.CommonUserBean;
import com.amazin.nayra.common.DataContainer;
import com.amazin.nayra.service.UserService;
import com.amazin.nayra.util.ResponseEntityCode;

@RestController
@RequestMapping(value = "/users")
public class UserConntroller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonUserBean commonUserBean;
	
	
	
//	@GetMapping("/forgotPassword/{email}")
//	public boolean forgotPassword(@PathVariable String email) {
//		 return userService.forgotPassword(email);
//	}
	
	@PostMapping("/forgotPassword/{email}")
	public ResponseEntity<Object> forgetPassword(@PathVariable String email,HttpServletRequest httpServletRequest) {
		
		System.out.println("usDataContainererName come from UI....." + email);
		DataContainer resetCase = userService.forgetPassword(email);
		if (resetCase.getMsg().equalsIgnoreCase("success")) {
			return new ResponseEntity<Object>(
					ResponseEntityCode.getReturnObjectString("Reset Password Done Successfully"), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(ResponseEntityCode.getReturnObjectStringErrorCase(resetCase.getMsg()),
					HttpStatus.OK);

		}
	}
	
	
	
//	@PostMapping("/changePassword")
//	public Users changeUserPassword(@RequestBody UserChangePwdRequest str) {
//		return userService.changePassword( str.getUid(),str.getOldPassword(),str.getNewPassword());
//	}

}
