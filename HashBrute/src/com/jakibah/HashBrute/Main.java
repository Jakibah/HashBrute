package com.jakibah.HashBrute;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main implements Runnable {

	private static boolean running = false;
	private JFrame MainFrame = new JFrame();
	private Label ChooseMode = new Label("Choose a mode: ");
	private Checkbox Encrypt = new Checkbox("Encrypt");
	private Checkbox Decrypt = new Checkbox("Decrypt");
	private Label Space = new Label("");
	private Label InputLabel = new Label("Input: ");
	private TextField Input = new TextField();
	private Label OutputLabel = new Label("Output: ");
	private Label Output = new Label("");
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
		MainFrame.setSize(300, 250);
		MainFrame.setResizable(false);
		/////////////////////////////////////////////////////////
		MainFrame.getContentPane().add(ChooseMode);
		MainFrame.getContentPane().add(Encrypt);
		MainFrame.getContentPane().add(Decrypt);
		MainFrame.getContentPane().add(Space);
		MainFrame.getContentPane().add(InputLabel);
		MainFrame.getContentPane().add(Input);
		MainFrame.getContentPane().add(OutputLabel);
		MainFrame.getContentPane().add(Output);
		MainFrame.getContentPane().add(StartButton);
		/////////////////
		//MainFrame.pack();
		MainFrame.setVisible(true);
	}
	public void OnClose(){
		
	}

	@Override
	public void run() {
		running = true;

		OnStart();
		
		while (running) {

			
			//Crypters.Encrypt("jew", true);
			//Crypters.Decrypt("505c8383fd19e8fd720a777738a57a1");
		}
		
		OnClose();

	}

}
