import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Capitalizer implements Runnable{
	private Socket socket;
	private int clientNumber;

	public Capitalizer(Socket socket, int clientNumber){
		this.socket = socket;
		this.clientNumber = clientNumber;
	}

	public void run() {
		boolean running = true;
		try {
			while(running) {
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				String input = in.readUTF();
				if("stop".equals(input)) {
					running = false;
				} else {
					out.writeUTF(input.toUpperCase());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
