package com.jakibah.HashBrute;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Crypters {

	private static File list = new File("list.lst");
	public static int gen = 0;

	public static String Encrypt(String s, boolean CloseAfterThis) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		md.update(s.getBytes(), 0, s.length());
		String encrypted = new BigInteger(1, md.digest()).toString(16);
		if (CloseAfterThis) {
			Main.Stop();
			System.out.println(encrypted);
			return encrypted;
		} else {
			return encrypted;
		}
	}

	public static void Decrypt(String hash) {
		List<String> lines = null;

		if (!list.exists()) {
			try {
				list.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		try {
			lines = Files.readAllLines(list.toPath(), StandardCharsets.UTF_8);
		} catch (IOException e) {

			e.printStackTrace();
		}

		
		String encrypted = Encrypt(lines.get(gen), false);
		
		if (hash.equals(encrypted)) {
			System.out.println("Hash: " + hash + " is equal to String: "+lines.get(gen));
			Main.Stop();

		} else {
			if (gen < lines.size() - 1) {
				gen++;
				
			} else {
				System.out.println("Failed!!!");
				Main.Stop();
			}

		}
	}
}
