package com.amazin.nayra.util;

import org.springframework.stereotype.Service;

@Service
public class DateFormatMapping {

	public static final String  defaultDateFormat= "yyyy-mm-dd hh:mm:ss";
	public static final String  defaultDateTimeFormat = "yyyy-MM-dd";
	public static final String  defaultDateTimeFormatSAP = "dd.MM.yyyy";

	public static final String defaultDateTimeFormat1 = "yyyy-MM-dd HH:mm:ss";
	public static final String defaultDateTimeFormat2 = "yyyy-MM-dd/HH:mm:ss";


	public static final String defaultTimezone = "Asia/Kolkata";
	public static final long accessTokenExpiryTimeInMs = 1800000;
	public static final long otpExpiryTimeInMs = 300000;



	public static final int INVALID_USER = -2;
	public static final int NEW_USER = 0;
	public static final int ACTIVE_USER = 1;
	public static final int BLOCKED_USER = 2;
	public static final int USER_WITH_PWD_EXPIRY = 3;
	public static final Integer ENTITY_IS_DELETED = 1;
	public static final String ENTITY_IS_ACTIVE = "1";
	public static final String ENTITY_IS_ACTIVE_ForValue3 ="3";
	public static final String ENTITY_IS_ACTIVE_ForValue2 = "2";
	public static final Integer ENTITY_For_Approved =2;


	public static final int MAX_INVALID_LOGIN_ATTEMPTS = 5;
	public static final String ENTITY_IS_NOT_Deleted = "0";
	public static final String ENTITY_IS_NOT_ACTIVE = "0";
	public static final int PWD_HISTORY_COUNT = 5;

	public static final String ENTITY_IS_Deleted = "1";
	public static final String PASSWORD_HISTORY_SEPERATOR = "~#~";
	public static final String PWD_HISTROY_VIOLATION_MSG = "Last five passwords can not be used again. Please select another password.";
	public static final String FAIL_MSG = "fail";
	public static final String USER_REMOVED = "Account Deleted";
	public static final String PASSWORD_MISMATCH = "Password did not match.";
	public static final String PASSWORD_RESET="Password reset successsfully";
	public static final int default_lan_status=0;
	   public static final int default_print_count=0;
	   
	   public static final int default_invoice_status=0;
	   public static final int default_inovice_count=0;

	




	public static final String SUCCESS_MSG = "success";

	public synchronized int uniqueNumber()
	{
		return 1;
	}
	
		
	}

	
	


