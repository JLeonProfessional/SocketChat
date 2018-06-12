package john.chat;
import java.io.IOException;
import java.net.Socket;


public class Client {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost", 9090);
		Thread thread = new Thread(new Input(s));
		Thread thread2 = new Thread(new Receiver(s));
		thread2.start();
		thread.start();
	}
}
