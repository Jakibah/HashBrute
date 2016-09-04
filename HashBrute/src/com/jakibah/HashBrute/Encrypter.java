package com.jakibah.HashBrute;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Encrypter implements Runnable, ActionListener {

	private static boolean running = false;
	private JFrame EncryptFrame = new JFrame();
	private Label Name = new Label("Encrypter");
	private Label InputLabel = new Label("Input: ");
	private TextField Input = new TextField();
	private Label OutputLabel = new Label("Output: ");
	public static Label Output = new Label("");
	private Button StartButton = new Button("Start");

	public static void startmain() {
		Thread MainThread = new Thread(new Encrypter());
		MainThread.setName("encrypt");
		MainThread.start();

	}

	public static void Stop() {
		running = false;
	}

	public void OnStart() {
		EncryptFrame.setTitle("HashBrute by Jakibah");
		EncryptFrame.setIconImage((new ImageIcon("Icon.png").getImage()));
		EncryptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EncryptFrame.setLayout(new BoxLayout(EncryptFrame.getContentPane(), BoxLayout.Y_AXIS));
		EncryptFrame.setResizable(false);

		/////////////////////////////////////////////////////////
		EncryptFrame.getContentPane().add(Name);
		EncryptFrame.getContentPane().add(InputLabel);
		EncryptFrame.getContentPane().add(Input);
		EncryptFrame.getContentPane().add(OutputLabel);
		EncryptFrame.getContentPane().add(Output);
		EncryptFrame.getContentPane().add(StartButton);
		StartButton.addActionListener(this);
		/////////////////
		Encrypter.Output.setText("9cdfb439c7876e703e307864c9167a15");
        EncryptFrame.setLocationRelativeTo(Decrypter.DecryptFrame);
		EncryptFrame.pack();
		Encrypter.Output.setText("");
		EncryptFrame.setVisible(true);
	}

	public void OnClose() {
		EncryptFrame.pack();
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

			Output.setText("Encrypting...");
			Crypters.Encrypt(Input.getText(), true);

		}

		OnClose();

	}
}
