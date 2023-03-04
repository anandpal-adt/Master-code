package com.amazin.nayra.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CommonFunctions {
	//@Autowired
	//private ServiceManager serviceManager;

//	@Autowired
//	private LogHistoryServices logsServices;

	public static final Logger logger = LoggerFactory.getLogger(CommonFunctions.class);

	// This method is used to generate the unique sequence number .....
	public synchronized static Long getUniqueSequenceNumber(String uniqueNumber) {
		// Integer number=Integer.parseInt(uniqueNumber )+ 1;

		Long number = (Long.parseLong(uniqueNumber)) + 1;

		return number;
	}

	/***
	 * public void insertDataIntoMasterTable(String number, String requestType, int
	 * documentType, String uniqueId, String documnetNumber, Date fromDate, Date
	 * toDate, int mode) { MasterVehicleBeans masterVehicleBeans1 = new
	 * MasterVehicleBeans(); MasterHelperBeans masterHelperBeans1 = new
	 * MasterHelperBeans(); MasterVehicleBeans masterVehicleBeans; MasterHelperBeans
	 * masterHelperBeans; Optional<MasterDocumenTdetailsBeans> documnetsDetails =
	 * serviceManager.getMasterDocumentDetailsRepostitories().findById(documentType);
	 * MasterStatus
	 * masterStatus1=serviceManager.getMasterStatusRepositories().findByType("APPROVED
	 * BY SECURITY"); String docType = documnetsDetails.get().getType(); try {
	 * logger.info("Enter into insertData into Master table Method..........."); if
	 * (requestType.equalsIgnoreCase("vehicle")) {
	 * 
	 * masterVehicleBeans =
	 * serviceManager.getVehicleRepo().findByVehicleNumber(number);
	 * Optional<MasterStatus>
	 * masterStatusOptional=serviceManager.getMasterStatusRepositories().findById(masterVehicleBeans.getStatus());
	 * if(mode==1) {
	 * 
	 * if (masterVehicleBeans == null) { throw new NoDataFoundException("No record
	 * inserted in Master Vehicle Table because vehicle number you entered is not
	 * Exists"+ number); }
	 * 
	 * switch (docType) { case "VRC":
	 * 
	 * masterVehicleBeans.setRcNumber(documnetNumber);
	 * masterVehicleBeans.setRc_from(fromDate); masterVehicleBeans.setRc_to(toDate);
	 * break; case "PL":
	 * 
	 * masterVehicleBeans.setPollutionCertificateNumber(documnetNumber);
	 * masterVehicleBeans.setPollutionfromDate(fromDate);
	 * masterVehicleBeans.setPollutionToDate(toDate); break; case "IN":
	 * 
	 * masterVehicleBeans.setInsurancePolicyNum(documnetNumber);
	 * masterVehicleBeans.setInsurancePolicyFromDate(fromDate);
	 * masterVehicleBeans.setInsurancePolicyToDate(toDate);
	 * 
	 * break; case "FT": masterVehicleBeans.setFitness_number(documnetNumber);
	 * masterVehicleBeans.setFitnessExpireDateFrom(fromDate);
	 * masterVehicleBeans.setFitnessExpireDateTo(toDate); break; default: throw new
	 * NoDataFoundException("Document Type Of vehicle is not valid Please choose
	 * Valid Document Type"); }
	 * 
	 * 
	 * serviceManager.getVehicleRepo().save(masterVehicleBeans); }
	 * 
	 * else //if (mode != 1 &&
	 * !((masterStatusOptional.get().getType().equalsIgnoreCase("PENDING FROM
	 * SECURITY")|| (masterStatusOptional.get().getType().equalsIgnoreCase("REJECTED
	 * BY SECURITY"))))) { {
	 * 
	 * MasterStatus
	 * masterStatus=serviceManager.getMasterStatusRepositories().findByType("PENDING
	 * FROM SECURITY"); masterVehicleBeans.setStatus(masterStatus.getId());
	 * ObjectWriter stringObject = new
	 * ObjectMapper().writer().withDefaultPrettyPrinter(); String request1
	 * =stringObject.writeValueAsString(masterVehicleBeans);
	 * logsServices.insertVehicleHistoryLogs(masterVehicleBeans.getVehicleNumber() ,
	 * "vehicle",
	 * request1,masterVehicleBeans.getId(),(Integer.parseInt(masterVehicleBeans.getCommonFields().getCreatedBy())));
	 * masterVehicleBeans.setStatus(masterStatus1.getId());
	 * serviceManager.getVehicleRepo().save(masterVehicleBeans); //
	 * masterVehicleBeans1 =
	 * serviceManager.getVehicleRepo().save(masterVehicleBeans); }
	 * 
	 * 
	 * } else if (requestType.equalsIgnoreCase("helper") ||
	 * requestType.equalsIgnoreCase("driver")) { logger.info("insert data into
	 * Master Helper Table...............");
	 * 
	 * String userType=checkOnBasisOfDocumentType(documentType); masterHelperBeans =
	 * serviceManager.getHelperRepo().findByUniqueIdBase(uniqueId);
	 * Optional<MasterStatus>
	 * masterHelperStatusOptional=serviceManager.getMasterStatusRepositories().findById(masterHelperBeans.getStatus());
	 * if (mode == 1) {
	 * 
	 * 
	 * if (!userType.equalsIgnoreCase("FAILED")) {
	 * masterHelperBeans.setUserType(userType);
	 * masterHelperBeans.setDocument_number(documnetNumber);
	 * masterHelperBeans.setDocument_expiry_date(toDate);
	 * masterHelperBeans.setDocument_issue_date(fromDate);
	 * masterHelperBeans.setDocument_type(documentType); }
	 * serviceManager.getHelperRepo().save(masterHelperBeans); } else {
	 * 
	 * //if (mode != 1 &&
	 * !(masterHelperStatusOptional.get().getType().equalsIgnoreCase("PENDING FROM
	 * SECURITY"))) { MasterStatus
	 * masterStatusHelper=serviceManager.getMasterStatusRepositories().findByType("PENDING
	 * FROM SECURITY"); //masterHelperBeans.setUserType(userType);
	 * masterHelperBeans.setStatus(masterStatusHelper.getId()); ObjectWriter
	 * stringObject = new ObjectMapper().writer().withDefaultPrettyPrinter(); String
	 * request1 = stringObject.writeValueAsString(masterHelperBeans);
	 * logsServices.insertHelperHistoryLogs(masterHelperBeans.getUniqueId(),
	 * "helper",
	 * request1,masterHelperBeans.getId(),(Integer.parseInt(masterHelperBeans.getCommonFields().getCreatedBy())));
	 * masterHelperBeans.setStatus(masterStatus1.getId());
	 * serviceManager.getHelperRepo().save(masterHelperBeans); } }
	 * 
	 * 
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * public String checkOnBasisOfDocumentType(Integer documentType) {
	 * logger.info("Enter into method to check the document is for
	 * Helper/Driver............"+documentType );
	 * Optional<MasterDocumenTdetailsBeans>
	 * documentsDetails=serviceManager.getMasterDocumentDetailsRepostitories().findById(documentType);
	 * // Optional<MasterDocumenTdetailsBeans>
	 * documentsDetails=serviceManager.getMasterDocumentDetailsRepostitories().getByDocumentTypeValue(2);
	 * if (documentsDetails.isPresent()) { System.out.println("Enter into method to
	 * check the document is for Helper/Driver............"+documentType );
	 * switch(documentsDetails.get().getType()) { case "PP": return "H"; case "UID":
	 * return "H"; case "VID": return "H"; case "LC": return "D"; case "DL": return
	 * "H"; case "RC": return "H"; default: return "FAILED";
	 * 
	 * }
	 * 
	 * } else { return "FAILED"; } }
	 * 
	 */

//This method is used to send the message
	public void sendMessageOtp(String mobile, String sms) {
//String keyValues = "7a4ac19d-8371-11e9-ade6-0200cd936042";

		try {
//URL url1 = new URL("http://www.smsjust.com/sms/user/urlsms.php?username=amazinauto&pass=SstG74$@&senderid=652064&dest_mobileno="+ mobile + "&message=" + sms + "&response=Y");
			String messge = URLEncoder.encode(sms);
			URL url = new URL(
					"http://api.instaalerts.zone/SendSMS/sendmsg.php?uname=HMEL_PLMS&pass=H3Ml@pLM&send=myHMEL&dest=91"
							+ mobile + "&msg=" + messge);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	// This Method is used to generate TripId on the basis of Plant Code
//	public synchronized String generateTripId(Integer masterPlantId) {
//		Optional<MasterPlant> masterPlant = serviceManager.getMasterPlantRepositories().findById(masterPlantId);
//		try {
//			if (masterPlant.isPresent()) {
//				String movementCode = masterPlant.get().getCode();
//				String tripId = null;
//				SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
//				Date date = new Date(System.currentTimeMillis());
//				Random random = new Random();
//				tripId = movementCode + dateFormat.format(date);
//				return tripId;
//			} else {
//				return "NULL";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		return "NULL";
//
//	}

	// This method is used to get the remarks on the basis of remarks Id
//	public String getRemarksName(List<Integer> checkListIds) {
//		StringBuffer stringBuffer = new StringBuffer();
//		for (int i = 0; i < checkListIds.size(); i++) {
//			Optional<MasterRemarks> masterRemarks = serviceManager.getMasterRemarksRepositories()
//					.findById(checkListIds.get(i));
//			if (masterRemarks.isPresent()) {
//				stringBuffer.append(masterRemarks.get().getRemarks());
//				masterRemarks = null;
//			}
//		}
//		System.out.println(stringBuffer);
//		return stringBuffer.toString();
//	}

	// This function is used to update the session time if any hit coming on the
	// server....
//	public void updateUserSession(HttpServletRequest httpServletRequest) {
//		logger.info("Enter into updateUserSession method to update the session timing....");
//		Users users = serviceManager.getUserRepository().findUsersDetailsByRemoteIP(httpServletRequest.getRemoteAddr());
//		if (users != null) {
//			users.setAccessTokenExpiryDatetime(new Date());
//			serviceManager.getUserRepository().save(users);
//		}
//
//	}

	// This Method is used to convert the data into SHA-512 algorithm....
	public String encryptThisString(String input) {
		try {
			// getInstance() method is called with algorithm SHA-512
			MessageDigest md = MessageDigest.getInstance("SHA-512");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);

			// Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			// return the HashText
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		// xssfWorkbook.close();

	}

	

}
