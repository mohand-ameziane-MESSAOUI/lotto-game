
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.portable.UnknownException;



public class ClientMain{
	
	static int numC;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Client c1;
		String hostName = "localhost";
		Timer timer = new Timer();
		int port = 1234;
		boolean stop=false;
		Socket clientSocket ; 
		PrintWriter outt;
		BufferedReader inn;
		Output out;
		Input in;
		InputStreamReader ir;
		Scanner sc = new Scanner(System.in);
		String l;
		
			clientSocket = new Socket(hostName, port);
			//outt = new PrintWriter(clientSocket.getOutputStream(),true);
			//ir = new InputStreamReader(clientSocket.getInputStream());
			//inn = new BufferedReader(ir);
			
			
		
		c1= new Client(clientSocket);
		 c1.run();
	}
}
			




