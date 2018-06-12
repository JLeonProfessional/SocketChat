package john.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientWindow {
	JFrame frame;
	JTextArea textArea;
	JTextField textField;

	public ClientWindow() {
		JFrame frame = new JFrame("Chat");
		frame.setSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea = new JTextArea();
		textField = new JTextField();
		frame.getContentPane().add(textArea, BorderLayout.NORTH);
		frame.getContentPane().add(textField, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	public void addText(String text) {
		textArea.append(text + "\n");
	}
	
	public JTextField getTextField() {
		return textField;
	}
}
