package br.com.auto.generator;

import java.util.Base64;

import org.apache.log4j.Logger;

public class Encrypt {
	
	private Logger logger = Logger.getLogger(Encrypt.class);

	public static void main(String[] args) {
		Encrypt encrypt = new Encrypt();
		
		String string = encrypt.encryptBase64("12345678");
		
		System.out.println(string);
		
		System.out.println(encrypt.desencryptBase64(string));
		
	}

	public String encryptBase64(String encodedString) {
		logger.info("Encrypt para base64");
		String encryptBase64 = Base64.getEncoder().encodeToString(encodedString.getBytes());
		return encryptBase64;
	}
	
	public String desencryptBase64(String decodedString) {
		logger.info("Desencrypt de base64");
		byte[] decodedBytes = Base64.getDecoder().decode(decodedString);
		String desencryptBase64 = new String(decodedBytes);
		return desencryptBase64;
	}

}
