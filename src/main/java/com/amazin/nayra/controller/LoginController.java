package com.amazin.nayra.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazin.nayra.common.CommonUserBean;
import com.amazin.nayra.common.DataContainer;
import com.amazin.nayra.model.MenuMain;
import com.amazin.nayra.model.Users;
import com.amazin.nayra.request.LoginRequest;
import com.amazin.nayra.service.LoginService;
import com.amazin.nayra.service.UserService;
import com.amazin.nayra.util.CommonFunctions;
import com.amazin.nayra.util.ResponseEntityCode;
//import com.sun.jna.platform.win32.WinUser.HHOOK;

@EnableAutoConfiguration
@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommonUserBean commonUserBean;

	@Autowired
	CommonFunctions commonFunctions;
	
	@PostMapping(value = "/public/authenticate")
	@CrossOrigin("*")
	public ResponseEntity<Object> login(@RequestBody LoginRequest authenticationRequest,
			HttpServletRequest httpServletRequest) throws Exception {
          
		if(authenticationRequest.getUsername()!=null) {
		DataContainer user = loginService.LoginbyUserName(authenticationRequest.getUsername(),
				authenticationRequest.getPassword(), httpServletRequest);
		
		if (user.getStatus().equalsIgnoreCase("failed")) {
			return new ResponseEntity<Object>(ResponseEntityCode.getReturnObjectStringErrorCase(user.getMsg()),
					HttpStatus.OK);
		} else if (user.getStatus().equalsIgnoreCase("success")) {
//			Users user2 = serviceManager.getUserRepository().findNameNew(authenticationRequest.getUsername());
			Users user2=userService.findByUserName(authenticationRequest.getUsername());
			//Iterable<MenuMain> menuMain = serviceManager.getMenuMainRepository().findAllpages();
			//Iterable<MenuMain> menuMain=userService.findAllpages();
			//commonUserBean.setUsers(user2);
			//commonUserBean.setMenuMain(menuMain);
			//return new ResponseEntity<Object>(ResponseEntityCode.getReturnObject(commonUserBean), HttpStatus.OK);
			
			return new ResponseEntity<Object>(HttpStatus.OK);

		}

		else {
			return new ResponseEntity<Object>(ResponseEntityCode.getReturnObjectStringErrorCase("Invalid Credentials"),
					HttpStatus.OK);
		}
		
		} else if(authenticationRequest.getEmail()!=null) {
			
			DataContainer user = loginService.LoginByEmail(authenticationRequest.getEmail(),
					authenticationRequest.getPassword(), httpServletRequest);
			
			if (user.getStatus().equalsIgnoreCase("failed")) {
				return new ResponseEntity<Object>(ResponseEntityCode.getReturnObjectStringErrorCase(user.getMsg()),
						HttpStatus.OK);
			} else if (user.getStatus().equalsIgnoreCase("success")) {
				Users user2=userService.findByUserName(authenticationRequest.getUsername());
				//Iterable<MenuMain> menuMain = serviceManager.getMenuMainRepository().findAllpages();
				Iterable<MenuMain> menuMain=userService.findAllpages();
				commonUserBean.setUsers(user2);
				commonUserBean.setMenuMain(menuMain);
				return new ResponseEntity<Object>(ResponseEntityCode.getReturnObject(commonUserBean), HttpStatus.OK);
			}

			else {
				return new ResponseEntity<Object>(ResponseEntityCode.getReturnObjectStringErrorCase("Invalid Credentials"),
						HttpStatus.OK);
		}
		
		

	}else {
		
		DataContainer user = loginService.LoginbyContactNumber(authenticationRequest.getContact(),
				authenticationRequest.getPassword(), httpServletRequest);
		
		if (user.getStatus().equalsIgnoreCase("failed")) {
			return new ResponseEntity<Object>(ResponseEntityCode.getReturnObjectStringErrorCase(user.getMsg()),
					HttpStatus.OK);
		} else if (user.getStatus().equalsIgnoreCase("success")) {
			Users user2=userService.findByUserName(authenticationRequest.getUsername());
			//Iterable<MenuMain> menuMain = serviceManager.getMenuMainRepository().findAllpages();
			Iterable<MenuMain> menuMain=userService.findAllpages();
			commonUserBean.setUsers(user2);
			commonUserBean.setMenuMain(menuMain);
			return new ResponseEntity<Object>(ResponseEntityCode.getReturnObject(commonUserBean), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<Object>(ResponseEntityCode.getReturnObjectStringErrorCase("Invalid Credentials"),
					HttpStatus.OK);
		}
		
	}
	
	}
}
