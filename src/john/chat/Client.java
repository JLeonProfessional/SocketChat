package john.chat;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;


public class Client {
	public static void main(String[] args) throws IOException {
		ClientWindow window = new ClientWindow();
		Socket socket = new Socket("localhost", 9090);
		Thread thread = new Thread(new Input(socket, window));
		Thread thread2 = new Thread(new Receiver(socket, window));
		thread2.start();
		thread.start();
	}
}
