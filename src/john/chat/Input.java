package john.chat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Input implements Runnable{
	private Socket socket;

	public Input (Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			while(true) {
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				DataInputStream input = new DataInputStream(socket.getInputStream());
				String msg = new Scanner(System.in).nextLine();
				output.writeUTF(msg);
				if("stop".equals(msg)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
