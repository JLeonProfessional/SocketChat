package john.chat;
import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class Input implements Runnable{
	private Socket socket;
	private ClientWindow window;
	private DataOutputStream output;

	public Input (Socket socket, ClientWindow window) throws IOException {
		this.socket = socket;
		output = new DataOutputStream(socket.getOutputStream());
		this.window = window;
	}
	
	Action action = new AbstractAction()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	        try {
				output.writeUTF(window.getTextField().getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }
	};
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		window.addText("Enter your name");
		window.getTextField().addActionListener(action);
		String name = scanner.nextLine();
		try {
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
