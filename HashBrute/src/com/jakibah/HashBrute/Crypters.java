package com.jakibah.HashBrute;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypters {

	public static String Encrypt(String s) throws NoSuchAlgorithmException{
		MessageDigest md = null;
		md =MessageDigest.getInstance("MD5");
		md.update(s.getBytes(),0,s.length());
		String encrypted = new BigInteger(1,md.digest()).toString(16);
		Main.Stop();
		return encrypted;
	}
}
