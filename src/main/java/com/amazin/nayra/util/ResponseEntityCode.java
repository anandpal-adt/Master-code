package com.amazin.nayra.util;


import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class ResponseEntityCode {

	public static final Logger logger = LoggerFactory
			.getLogger(ResponseEntityCode.class);

	public synchronized static Map<String, Object> getReturnObject(
			Object returnableObj) {
		Map<String, Object> successObjectReturnJson = new TreeMap<String, Object>(
				Collections.reverseOrder());
		successObjectReturnJson.put("status", HttpStatus.OK.toString());
		successObjectReturnJson.put("data", returnableObj);
		return successObjectReturnJson;
	}

	public synchronized static Map<String, Object> getReturnObjectClass(
			Object returnableObj1, Object retunableObj2) {
		Map<String, Object> successObjectReturnJson = new TreeMap<String, Object>(
				Collections.reverseOrder());
		successObjectReturnJson.put("status", HttpStatus.OK.toString());
		successObjectReturnJson.put("data", returnableObj1);
		successObjectReturnJson.put("data2", retunableObj2);
		return successObjectReturnJson;
	}

	public synchronized static Map<String, String> getReturnObjectString(String returnableStr) {
		Map<String, String> SuccessStringReturnJson = new TreeMap<String, String>(
				Collections.reverseOrder());
		SuccessStringReturnJson.put("status", HttpStatus.OK.toString());
		SuccessStringReturnJson.put("message", returnableStr);
		return SuccessStringReturnJson;
	}

	public synchronized static Map<String, String> getReturnObjectStringErrorCase(String returnableStr) {
		Map<String, String> SuccessStringReturnJson = new TreeMap<String, String>(
				Collections.reverseOrder());
		SuccessStringReturnJson.put("status", HttpStatus.NOT_ACCEPTABLE.toString());
		SuccessStringReturnJson.put("message", returnableStr);
		return SuccessStringReturnJson;
	}
/*	public static <T> ResponseEntity<T> ok(T body) {
		ResponseEntity.BodyBuilder builder = ok();
		return builder.body(body);
	}*/





	public synchronized static Map<String, Object> getReturnObjectList(Object returnableObj1) {
		Map<String, Object> successObjectReturnJson = new TreeMap<String, Object>(
				Collections.reverseOrder());
		successObjectReturnJson.put("status", HttpStatus.OK.toString());
		successObjectReturnJson.put("data", returnableObj1);

		return successObjectReturnJson;
	}

	/*public static Object getReturnObject(String s, JwtResponse jwtResponse) {
		DataContainer dataContainer=new DataContainer();
		dataContainer.setMsg("success");
		dataContainer.setData(jwtResponse);
			return dataContainer;
	}*/
}
