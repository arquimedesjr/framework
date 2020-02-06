package br.com.auto.generator;

import java.util.Base64;

public class Encrypt {

	public static void main(String[] args) {
		Encrypt encrypt = new Encrypt();
		
		String string = encrypt.encryptBase64("12345678");
		
		System.out.println(string);
		
		System.out.println(encrypt.desencryptBase64(string));
		
	}

	public String encryptBase64(String encodedString) {
		
		String encryptBase64 = Base64.getEncoder().encodeToString(encodedString.getBytes());
		return encryptBase64;
	}
	
	public String desencryptBase64(String decodedString) {
		
		byte[] decodedBytes = Base64.getDecoder().decode(decodedString);
		String desencryptBase64 = new String(decodedBytes);
		return desencryptBase64;
	}

}
