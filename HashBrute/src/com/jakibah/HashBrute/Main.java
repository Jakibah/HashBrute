package com.jakibah.HashBrute;

import java.security.NoSuchAlgorithmException;

public class Main implements Runnable{
	
	private static boolean running = false;

	public static void main(String[] args) {
		Thread MainThread = new Thread(new Main());
		MainThread.setName("main");
		MainThread.start();

	}

	public static void Stop(){
		running = false;
	}
	
	@Override
	public void run() {
		running = true;
		
		while(running){
			
			try {
				System.out.println(Crypters.Encrypt("test123"));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
