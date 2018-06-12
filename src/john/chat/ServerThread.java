package john.chat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread implements Runnable{
	private Socket socket;
	private int clientNumber;
	private ArrayList<Socket> listSockets;

	public ServerThread(Socket socket, int clientNumber, ArrayList<Socket> listSockets){
		this.socket = socket;
		this.clientNumber = clientNumber;
		this.listSockets = listSockets;
	}

	public void run() {
		boolean running = true;
		DataOutputStream out;
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String name = in.readUTF();
			for(int i = 0; i < listSockets.size(); i++) {
				out = new DataOutputStream(listSockets.get(i).getOutputStream());
				out.writeUTF(clientNumber + ":" + name + " has entered the room.");
			}
			while(running) {
				out = new DataOutputStream(socket.getOutputStream());
				String input = in.readUTF();
				if("stop".equals(input)) {
					running = false;
				} else {
					for(int i = 0; i < listSockets.size(); i++) {
						out = new DataOutputStream(listSockets.get(i).getOutputStream());
						out.writeUTF(clientNumber + ": " + input);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setListSockets(ArrayList<Socket> listSockets) {
		this.listSockets = listSockets;
	}
}
