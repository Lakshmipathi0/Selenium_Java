package com.brigita.base;

import java.util.Base64;

public class EncodeDecode {
	
	/**
	 * @author Mahesh 
	 * @param data - String that needs to be Encrypted
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String data) throws Exception{

		byte[] passwordBytes = data.getBytes();  
		String encrypt = Base64.getEncoder().encodeToString(passwordBytes);
		//byte[] encrypt= Base64.getEncoder().encode (data.getBytes());
		System.out.println("Encyrpted password ----->"+encrypt);
		return encrypt;
	}

	/** 
	 * @author Mahesh
	 * 
	 * @param data - Encrypted data needs to be passed
	 * @return
	 * @throws Exception
	 */
	public String decrypt(String data) throws Exception{

		byte[] passwordBytes= Base64.getDecoder().decode(data);
		//byte[] decrypt= Base64.getDecoder().decode (data.getBytes());
		String decrypt = new String(passwordBytes);
		System.out.println("Decyrpted data ----->"+decrypt);
		return decrypt;
	}

}
