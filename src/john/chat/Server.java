package john.chat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(9090);
		int clientNumber = 0;
		ArrayList<Socket> listSockets = new ArrayList<Socket>();
		ArrayList<ServerThread> listServers = new ArrayList<ServerThread>();
		while (true) {
			Socket socket = listener.accept();
			listSockets.add(socket);
			ServerThread serverThread = new ServerThread(socket, clientNumber, listSockets);
			listServers.add(serverThread);
			for(int i = 0; i < listServers.size(); i++) {
				listServers.get(i).setListSockets(listSockets);
			}
			Thread thread = new Thread(serverThread);
			thread.start();
			clientNumber++;
		}
	}
}
