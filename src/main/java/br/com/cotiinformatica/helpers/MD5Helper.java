package br.com.cotiinformatica.helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Helper {

	public static String encrypt(String input) {

		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);
			String hashText = no.toString(16);

			while (hashText.length() < 32) {
				hashText = "0" + hashText;
			}

			return hashText;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
