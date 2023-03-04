package com.amazin.nayra.serviceImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.amazin.nayra.common.DataContainer;
import com.amazin.nayra.common.MailService;
import com.amazin.nayra.common.PasswordUtil;
import com.amazin.nayra.model.Users;
import com.amazin.nayra.repository.UserRepository;
import com.amazin.nayra.service.LoginService;
import com.amazin.nayra.util.CommonFunctions;
import com.amazin.nayra.util.DateFormatMapping;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailService mailService;

	private PasswordUtil pwdUtil = new PasswordUtil();
	CommonFunctions commonFunctions = new CommonFunctions();
	SimpleDateFormat dt1 = new SimpleDateFormat("YYYY-MM-dd");

	@Override
	public DataContainer LoginbyUserName(String username, String password, HttpServletRequest httpServletRequest) {

		System.out.println("=================================inside method");

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		DataContainer dataContainer = new DataContainer();
		Users user = userRepository.findByUserName(username);

		if (user == null) {
			dataContainer.setStatus("failed");
			dataContainer.setMsg("Invalid Username " + username);
			return dataContainer;
		}
		if (user.getInvalid_login_attempts() == null) {
			
			
			user.setOtp(null);
			
			mailService.sendSimpleMessage("sandeep.kumar@amzbizsol.in", "login for OPT", "Dear " + user.getFirstname()
				+ ", \n\nYour login otp is "+user.getChange_password_count());

		}else {

		System.out.println(user.getPasswordsalt());
		System.out.println(password);

		// this condition is used to check the user is login on any system or not...
		if (user.getAccess_token() != null) {
			// This condition is used to check whether same user session is already active
			// or not........
			if (user.getAccess_token().equalsIgnoreCase(httpServletRequest.getRemoteAddr())) {
				dataContainer.setStatus("success");
				user.setAccess_token(httpServletRequest.getRemoteAddr());
				user.setAccess_token_expiry_datetime(new Date());
				userRepository.save(user);
			} else {
				dataContainer.setStatus("success");
				user.setAccess_token(httpServletRequest.getRemoteAddr());
				user.setAccess_token_expiry_datetime(new Date());
				userRepository.save(user);
			}
		} else {
			dataContainer.setStatus("success");
			user.setAccess_token(httpServletRequest.getRemoteAddr());
			user.setAccess_token_expiry_datetime(new Date());
			userRepository.save(user);
		}
		}

		return dataContainer;
	}
		

	@Override
	public DataContainer LoginByEmail(String email, String password, HttpServletRequest httpServletRequest) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		DataContainer dataContainer = new DataContainer();
		Users user = userRepository.findByEmail(email);

		if (user == null) {
			dataContainer.setStatus("failed");
			dataContainer.setMsg("Invalid Username " + email);
			return dataContainer;
		}
		System.out.println(user.getPasswordsalt());
		System.out.println(commonFunctions.encryptThisString(password));

		// this condition is used to check the user is login on any system or not...
		if (user.getAccess_token() != null) {
			// This condition is used to check whether same user session is already active
			// or not........
			if (user.getAccess_token().equalsIgnoreCase(httpServletRequest.getRemoteAddr())) {
				dataContainer.setStatus("success");
				user.setAccess_token(httpServletRequest.getRemoteAddr());
				user.setAccess_token_expiry_datetime(new Date());
				userRepository.save(user);
			} else {
				dataContainer.setStatus("success");
				user.setAccess_token(httpServletRequest.getRemoteAddr());
				user.setAccess_token_expiry_datetime(new Date());
				userRepository.save(user);
			}
		} else {
			dataContainer.setStatus("success");
			user.setAccess_token(httpServletRequest.getRemoteAddr());
			user.setAccess_token_expiry_datetime(new Date());
			userRepository.save(user);
		}

		return dataContainer;
	}

	@Override
	public DataContainer LoginbyContactNumber(String contact, String password, HttpServletRequest httpServletRequest) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		DataContainer dataContainer = new DataContainer();
		Users user = userRepository.findByContact(contact);

		if (user == null) {
			dataContainer.setStatus("failed");
			dataContainer.setMsg("Invalid Username " + contact);
			return dataContainer;
		}
		System.out.println(user.getPasswordsalt());
		System.out.println(commonFunctions.encryptThisString(password));

		// this condition is used to check the user is login on any system or not...
		if (user.getAccess_token() != null) {
			// This condition is used to check whether same user session is already active
			// or not........
			if (user.getAccess_token().equalsIgnoreCase(httpServletRequest.getRemoteAddr())) {
				dataContainer.setStatus("success");
				user.setAccess_token(httpServletRequest.getRemoteAddr());
				user.setAccess_token_expiry_datetime(new Date());
				userRepository.save(user);
			} else {
				dataContainer.setStatus("success");
				user.setAccess_token(httpServletRequest.getRemoteAddr());
				user.setAccess_token_expiry_datetime(new Date());
				userRepository.save(user);
			}
		} else {
			dataContainer.setStatus("success");
			user.setAccess_token(httpServletRequest.getRemoteAddr());
			user.setAccess_token_expiry_datetime(new Date());
			userRepository.save(user);
		}

		return dataContainer;
	}

	public Users checkPassword(Users user, String password, Date currentTimestamp, Date lastLoginTime) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setUser_lastlogin_datetime(lastLoginTime);
		String dbPassword = user.getPassword();
		System.out.println("DataBase Password............" + dbPassword);

		return user;
	}

}
