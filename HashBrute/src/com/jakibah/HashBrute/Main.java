package com.jakibah.HashBrute;

import java.security.NoSuchAlgorithmException;

public class Main implements Runnable{
	
	private static boolean running = false;

	public static void main(String[] args) {
		Thread Main = new Thread(new Main());
		Main.setName("main");
		Main.start();

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
