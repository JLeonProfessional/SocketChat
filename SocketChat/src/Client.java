import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost", 9090);
		Thread thread = new Thread(new Input(s));
		thread.start();
	}
}
