package com.jakibah.HashBrute;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Decrypter implements Runnable, ActionListener {

	private static boolean running = false;
	public static JFrame DecryptFrame = new JFrame();
	private Label Name = new Label("Decrypter");
	private Label InputLabel = new Label("Input: ");
	private TextField Input = new TextField();
	private Label OutputLabel = new Label("Output: ");
	public static Label Output = new Label("");
	private Button StartButton = new Button("Start");

	public static void startmain() {
		Thread MainThread = new Thread(new Decrypter());
		MainThread.setName("decrypt");
		MainThread.start();

	}

	public static void Stop() {
		running = false;
	}

	public void OnStart() {
		DecryptFrame.setTitle("HashBrute by Jakibah");
		DecryptFrame.setIconImage((new ImageIcon("Icon.png").getImage()));
		DecryptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DecryptFrame.setLayout(new BoxLayout(DecryptFrame.getContentPane(), BoxLayout.Y_AXIS));
		DecryptFrame.setResizable(false);

		/////////////////////////////////////////////////////////
		DecryptFrame.getContentPane().add(Name);
		DecryptFrame.getContentPane().add(InputLabel);
		DecryptFrame.getContentPane().add(Input);
		DecryptFrame.getContentPane().add(OutputLabel);
		DecryptFrame.getContentPane().add(Output);
		DecryptFrame.getContentPane().add(StartButton);
		StartButton.addActionListener(this);
		/////////////////
		Decrypter.Output.setText("Decrypted Succesfully result can be found in output file!");

		DecryptFrame.pack();
		Decrypter.Output.setText("");
		DecryptFrame.setVisible(true);
	}

	public static void Failed() {
		Output.setText("Decryption failed we can not decrypt this hash.");
	}

	public void OnClose() {
		DecryptFrame.pack();
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

			Output.setText("Decrypting...");
			Crypters.Decrypt(Input.getText());

		}

		OnClose();

	}

}
