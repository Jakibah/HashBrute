package com.jakibah.HashBrute;

import java.security.NoSuchAlgorithmException;

import javax.swing.JFrame;

public class Main implements Runnable {

	private static boolean running = false;
	private JFrame MainFrame = new JFrame();

	public static void main(String[] args) {
		Thread MainThread = new Thread(new Main());
		MainThread.setName("main");
		MainThread.start();

	}

	public static void Stop() {
		running = false;
	}

	@Override
	public void run() {
		running = true;

		while (running) {

			//System.out.println(Crypters.Encrypt("test123", true));
			//Crypters.Decrypt("test123");
		}

	}

}
