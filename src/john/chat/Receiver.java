package john.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver implements Runnable{

	private Socket socket;
	private ClientWindow window;

	public Receiver(Socket socket, ClientWindow window) {
		this.socket = socket;
		this.window = window;
	}



	@Override
	public void run() {
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			while(true) {
				String input = in.readUTF();
				System.out.println(input);
				window.addText(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
