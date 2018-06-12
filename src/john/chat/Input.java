package john.chat;
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		try {
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(name);
			while(true) {
				String msg = scanner.nextLine();
				output.writeUTF(msg);
				if("stop".equals(msg)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
		
	}

}
