package com.amazin.nayra.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class SmsController {
	
	@GetMapping("/sendSMS")
	public String sendSms() {
		try {
			// Construct data
			String apiKey = "apikey=" + URLEncoder.encode("yourapiKey", "UTF-8");
			String message = "&message=" + URLEncoder.encode("This is your message", "UTF-8");
			String sender = "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8");
			String numbers = "&numbers=" + URLEncoder.encode("917771935143", "UTF-8");
			
			// Send data
			String data = "https://api.textlocal.in/send/?" + apiKey + numbers + message + sender;
			URL url = new URL(data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sResult="";
			while ((line = rd.readLine()) != null) {
			// Process line...
				sResult=sResult+line+" ";
			}
			rd.close();
			
			return sResult;
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
