package com.jakibah.HashBrute;


import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main implements Runnable, ActionListener {

	private static boolean running = false;
	private JFrame MainFrame = new JFrame();
	private Label InputLabel = new Label("Input: ");
	private TextField Input = new TextField();
	private Label OutputLabel = new Label("Output: ");
	public static Label Output = new Label("");
	private Button StartButton = new Button("Start");
	
	

	public static void main(String[] args) {
		Thread MainThread = new Thread(new Main());
		MainThread.setName("main");
		MainThread.start();

	}

	public static void Stop() {
		running = false;
	}
	public void OnStart(){
		MainFrame.setTitle("HashBrute by Jakibah");
		MainFrame.setIconImage((new ImageIcon("Icon.png").getImage()));
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setLayout(new BoxLayout(MainFrame.getContentPane(), BoxLayout.Y_AXIS));
		MainFrame.setResizable(false);
		
		/////////////////////////////////////////////////////////
		MainFrame.getContentPane().add(InputLabel);
		MainFrame.getContentPane().add(Input);
		MainFrame.getContentPane().add(OutputLabel);
		MainFrame.getContentPane().add(Output);
		MainFrame.getContentPane().add(StartButton);
		StartButton.addActionListener(this);
		/////////////////
		MainFrame.pack();
		MainFrame.setVisible(true);
	}
	public static void Failed(){
		Output.setText("Decryption failed we can not decrypt this hash");
	}
	public void OnClose(){
		
	}

	@Override
	public void run() {
		

		OnStart();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		running = true;
		StartButton.setEnabled(false);
		while (running) {

			System.out.println("Debugging...");
			Output.setText("Decrypting...");
			MainFrame.pack();
			//Crypters.Encrypt("jew", true);
			//Crypters.Decrypt(Input.getText());
			//Crypters.Decrypt("505c8383fd19e8fd720a777738a57a1");
			Crypters.Decrypt(Output.getText().toString());
		}
		
		OnClose();
		
	}

	
	
		
	}
	


