import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(9090);
		int clientNumber = 0;
		while (true) {
			Socket socket = listener.accept();
			Thread thread = new Thread(new Capitalizer(socket, clientNumber++));
			thread.start();
		}
	}
}
