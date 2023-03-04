package com.amazin.nayra.serviceImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amazin.nayra.common.DataContainer;
import com.amazin.nayra.common.MailService;
import com.amazin.nayra.common.MasterUtil;
import com.amazin.nayra.common.PasswordUtil;
import com.amazin.nayra.entity.CommonConstants;
import com.amazin.nayra.model.Department;
import com.amazin.nayra.model.MenuMain;
import com.amazin.nayra.model.Role;
import com.amazin.nayra.model.Users;
import com.amazin.nayra.repository.CommonConstantsRepository;
import com.amazin.nayra.repository.DepartmentRepository;
import com.amazin.nayra.repository.MainMenuRepository;
import com.amazin.nayra.repository.RoleRepository;
import com.amazin.nayra.repository.UserRepository;
import com.amazin.nayra.request.UserRequest;
import com.amazin.nayra.service.UserService;
import com.amazin.nayra.util.CommonFunctions;
import com.amazin.nayra.util.DateFormatMapping;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private MainMenuRepository mainMenuRepository;
	
//	@Autowired(required = false)
//	private PasswordEncoder passwordEncoder;
	
	@Autowired(required = false)
	MailService mailService;
	
	@Autowired
	private CommonConstantsRepository commonConstantsRepository;
	
	SimpleDateFormat dt1 = new SimpleDateFormat("YYYY-MM-dd");
	
	private PasswordUtil pwdUtil = new PasswordUtil();
	CommonFunctions commonFunctions = new CommonFunctions();

	@Override
	public Users userRegister(UserRequest str, Integer id) {
		
		Optional<UserRequest> ur = Optional.ofNullable(str);

		String role = ur.get().getRole();
		Optional<Role> r = roleRepository.findByRoleName(role);
		if (!r.isPresent()) {
			throw new NoSuchElementException("Role not found " + role);
		}

//		String departmentName = ur.get().getDepartment();
//		Optional<Department> b = departmentRepository.findBydepartmentName(departmentName);
//		if (!b.isPresent()) {
//			throw new NoSuchElementException("Department not found ");
//		}

		Optional<Users> u = userRepository.findById(id);
		if (!u.isPresent()) {
			throw new NoSuchElementException("User not found ");
		}
//		String email1 = ur.get().getEmail();
//		Users checkEmail = userRepository.findByEmail(email1);
//		if (checkEmail != null && !checkEmail.equals("")) {
//			throw new NoSuchElementException(email1 + "  already registered on this server ");
//		}
//		String phoneNo = ur.get().getContact();
//		Users up = userRepository.findByContact(phoneNo);
//		if (up != null && !up.equals("")) {
//			throw new NoSuchElementException(phoneNo + "  already registered on this server ");
//		}
		
		
		
		String firstName = ur.get().getFirstname();
		String lastName = ur.get().getLastname();
		String uniqueId = ur.get().getUniqueId();
		String passwordhash = ur.get().getPasswordhash();
		String passwordsalt = ur.get().getPasswordsalt();
		String plantname =ur.get().getPlantname();
		String email=ur.get().getEmail();
		String contact=ur.get().getContact();
		String managername=ur.get().getManagername();
		String address=ur.get().getAddress();
		String city=ur.get().getCity();
		String remarks=ur.get().getRemarks();
		//String 
		
		
		Users user=new Users();
		//user.setUnique_id(uniqueId);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setPasswordhash(passwordhash);
        user.setPasswordsalt(passwordsalt);
        user.setPlant_name(plantname);
        user.setEmail(email);
        user.setContact(contact);
        user.setManager_name(managername);
        user.setAddress(address);
        user.setCity(city);
        user.setRemarks(remarks);
        
		userRepository.save(user);
		//userService.addUser(user);

		// final String baseUrl =
		// ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
//		try {
//			mailService.sendSimpleMessage(email.trim(), "Report : ",
//					"Hello " + title + " " + firstName
//							+ " ,\n\nThank you for registering with us. Kindly login using the credentials below:\n\n"
//							+ email.trim() + " \nPassword: " + pwd);
//		} catch (Exception e) {
//			// LOGGER.error(" Dear " + ur.get().getEmail() + " Mail fail due to " +
//			// e.getMessage());
//		}
	
	
		return user;
		
	}

//	@Override
//	public boolean forgotPassword(String email) {
//		boolean flag = false;
//		Users user = userRepository.findByEmail(email);
//		if (user == null)
//			throw new NoSuchElementException("User data not found");
//		String newPassword = getRandomString(10);
//
//		user.setPasswordhash(passwordEncoder.encode(newPassword));
//		user.setResetPasswordDate(new Date());
//		user = userRepository.save(user);
//		flag = true;
//		mailService.sendSimpleMessage(email, "Reset Password", "Dear " + user.getFirstname()
//				+ ", \n\nYour password has been reset successfully. \n\nPassword: " + newPassword);
//		return flag;
//
//	}

	private String getRandomString(int n) {
		String AlphaNumericString = "A1B2C3D4E5F6#G7H8I9JKL@MNOPQR1233456STUVW$XYZ@" + "0123456789" + "#@$&"
				+ "a1b2c3d9e6f8g1h4i5j6k7lmnop#qrst$uvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

//	@Override
//	public Users changePassword(Integer id, String oPassword, String nPassword) {
//		try {
//			Optional<Users> user = userRepository.findById(id);
//
//			if (!user.isPresent()) {
//				throw new NoSuchElementException("User not found!");
//			}
//			nPassword = MasterUtil.decrytBase64(nPassword);
//			String newPassword = MasterUtil.decryptAES(nPassword);
//
//			oPassword = MasterUtil.decrytBase64(oPassword);
//			String oldPassword = MasterUtil.decryptAES(oPassword);
//
//			boolean result = passwordEncoder.matches(oldPassword, user.get().getPasswordhash());
//			if (!result) {
//
//				throw new ValidationException("Old password miss match");
//			}
//
//			user.get().setPassword(passwordEncoder.encode(newPassword));
//			mailService.sendSimpleMessage(user.get().getEmail(), "Password Changed", "Dear " + user.get().getFirstname()
//				+ ", \n\nYour password has been changed successfully. \n\nPassword: " + newPassword);
//			userRepository.save(user.get());
//
//			return user.get();
//		} catch (Exception e) {
//			throw new RuntimeException(
//					"ERROR: " + e.getMessage() != null && e.getMessage().length() < 50 ? e.getMessage()
//							: "Your request fail to complete!");
//		}
//	}

	@Override
	public DataContainer forgetPassword(String email) {
		return null;
//		
//		String ressetMessage = "YOUR NEW NAYRA LOGIN PASSWORD: ";
//
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//
//	//	Users user = serviceManager.getUserRepository().findNameNew(userName);
//		Users user=userRepository.findByEmail(email);
//		DataContainer dataContainer = new DataContainer();
//
//		Calendar c1 = new GregorianCalendar();
//		c1.add(Calendar.DATE, 30);
//		Date date = c1.getTime();
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		try {
//			if (user != null) {
//
////				if (user.getCommonFields().getIsDeleted().equals("1")) {
////					dataContainer.setMsg(DateFormatMapping.USER_REMOVED);
////					System.out.println("user is removed " + user.getUsername());
////				} else {
//					// This condition is used to check the reset date of current user....
//					if (user.getResetPasswordDate() != null) {
//						CommonConstants commonConstants = commonConstantsRepository.findActiveRecordByCode("RESET_PASS");
//						String newDate = dt1.format(user.getResetPasswordDate());
//
//						// Case-1 if the reset date is equals to current date.....
//						if (LocalDate.parse(newDate).equals(LocalDate.now())) {
//							System.out.println("Both the Dates are equals......");
//							if ((commonConstants != null)
//								&& (user.getReset_password_count() < Integer.parseInt(commonConstants.getValue()))) {
//								user.setReset_password_count(user.getReset_password_count() + 1);
//							} else {
//								dataContainer.setMsg(
//										"You Are Not Allowed To Reset The Password Today.You Have Exceed The Limit.Please Try Tomorrow Or Contact With Administrator");
//								return dataContainer;
//							}
//						} else if (LocalDate.parse(newDate).isBefore(LocalDate.now())) {
//							user.setReset_password_count(1);
//							user.setReset_password_date(new Date());
//						}
//
//					} else {
//						user.setReset_password_date(new Date());
//						user.setReset_password_count(1);
//					}
//
//					String password = pwdUtil.generatePassword(8);
//					String newPassword1 = "";
//					try {
//						newPassword1 = (commonFunctions.encryptThisString(password));
//					} catch (Exception e) {
//						e.printStackTrace();
//						// TODO: handle exception
//					}
//					user.setPasswordhash(password);
//					user.setPasswordsalt(newPassword1);
//					user.setPassword(bCryptPasswordEncoder.encode(password));
//					//user.getCommonFields().setIsActive(Integer.toString(DateFormatMapping.ACTIVE_USER));
//					///user.setAccessToken(null);
//					//user.setAccessTokenExpiryDatetime(null);
//					//user.setInvalidLoginAttempts(0);
//					//user.setPwdResetDate(date);
//					userRepository.save(user);
//					// commonFunctions.sendMessageOtp((user.getPhoneNumber()),ressetMessage+user.getUsername()+"
//					// and password:"+user.getPasswordhash());
//					commonFunctions.sendMessageOtp((user.getContact()),
//							ressetMessage + password + ". from NAYARA.");
//					try {
//						mailService.sendSimpleMessage(email, "Reset Password", "Dear " + user.getFirstname()
//						+ ", \n\nYour password has been reset successfully. \n\nPassword: " + password);
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//
//					dataContainer.setMsg(DateFormatMapping.SUCCESS_MSG);
//
//				}
//
//			} else {
//
//				dataContainer.setMsg(DateFormatMapping.FAIL_MSG);
//
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return dataContainer;
	}
	
	


	@Override
	public Users findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public Users findByUserName(String username) {
		
		return userRepository.findByUserName(username);
	}

	@Override
	public Iterable<MenuMain> findAllpages() {
		return null;
		
		//return mainMenuRepository.findAllpages();
	}
	

	

}
