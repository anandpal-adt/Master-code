package com.amazin.nayra.common;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public interface MasterUtil {
	public final static int GCM_TAG_LENGTH = 128;
	public static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
	public static final int IV_LENGTH_BYTE = 12;
	public static final Charset UTF_8 = StandardCharsets.UTF_8;
	public static final ConcurrentHashMap<String, String> captchMap = new ConcurrentHashMap<String, String>();
	public static String FILENAME = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

	public static String decryptAES(String enString) throws Exception {
		byte[] decodedBytes = Base64.getDecoder().decode(AesGcm.KEY.getAction());
		String decodedKey = new String(decodedBytes);
		enString = decodedKey + enString;
		String keyString = enString.substring(0, 16);
		String ivString = enString.substring(16, 32);
		String additionalString = enString.substring(32, 56);
		String cipherString = enString.substring(56);
		byte[] keyBytes = keyString.getBytes();
		SecretKey key = new SecretKeySpec(keyBytes, "AES");
		byte[] ivBytes = ivString.getBytes();
		byte[] one = Base64.getMimeDecoder().decode(cipherString);
		byte[] two = Base64.getMimeDecoder().decode(additionalString);
		byte[] cipherText = ArrayUtils.addAll(one, two);
		return decrypt(cipherText, key, ivBytes);
	}

	public static String decrypt(byte[] cipherText, SecretKey key, byte[] IV) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
		GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, IV);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
		byte[] decodedBytes = Base64.getDecoder().decode(AesGcm.SECRET.getAction());
		String decodedKey = new String(decodedBytes);
		cipher.updateAAD(decodedKey.getBytes());
		byte[] decryptedText = cipher.doFinal(cipherText);
		return new String(decryptedText, "UTF-8");
	}

	public static String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	public static <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	public static <T> List<T> mapFromJsonList(String json, Class<T[]> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return Arrays.asList(objectMapper.readValue(json, clazz));
	}

	public static String encryptBase64(String str) {
		return Base64.getEncoder().encodeToString(str.getBytes());
	}

	public static String decrytBase64(String encData) {
		byte[] decodedBytes = Base64.getDecoder().decode(encData);
		return new String(decodedBytes);
	}

	public static byte[] encryptForAPI(byte[] pText, SecretKey secret, byte[] iv) throws Exception {
		Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
		cipher.init(Cipher.ENCRYPT_MODE, secret, new GCMParameterSpec(GCM_TAG_LENGTH, iv));
		byte[] encryptedText = cipher.doFinal(pText);
		return encryptedText;

	}

	public static byte[] getRandomNonce(int numBytes) {
		byte[] nonce = new byte[numBytes];
		new SecureRandom().nextBytes(nonce);
		return nonce;
	}

	public static String encryptDataForAPI(String pText,String key) throws Exception {
		byte[] keyBytes = decrytBase64(key).getBytes();
		SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
		byte[] iv = getRandomNonce(IV_LENGTH_BYTE);
		byte[] cipherText = encryptForAPI(pText.getBytes(UTF_8), secretKey, iv);
		byte[] cipherTextWithIv = ByteBuffer.allocate(iv.length + cipherText.length).put(iv).put(cipherText).array();
		return Base64.getEncoder().encodeToString(cipherTextWithIv);

	}
}