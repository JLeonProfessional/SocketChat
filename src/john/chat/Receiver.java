package john.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver implements Runnable{

	private Socket socket;

	public Receiver(Socket socket) {
		this.socket = socket;
	}



	@Override
	public void run() {
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			while(true) {
				String input = in.readUTF();
				System.out.println(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
