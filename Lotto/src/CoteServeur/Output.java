package CoteServeur;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class Output  {
	PrintWriter out;
	protected Socket clientSocket = null;
	Scanner sc = new Scanner(System.in);
	String [] ListCarton= new String[10];
	public static int l;
	int NbrRandom;
	Input in;
	private  Socket s;
	boolean stop=false;
	Random r = new Random();
	String nameC;
	Timer timer = new Timer();

	public Output(OutputStream out) throws IOException {
		this.out = new PrintWriter(out, true);
	}


	
	public synchronized void sendMessage(String msg) {
		out.println("TIRAGE");
		out.println(msg);
	}
	public synchronized void sendName() {
		out.println("veuiller entrer votre login svp");
	}

	public synchronized void sendCarton(String string){
		int x = r.nextInt(10);
		ListCarton[x]= string;
		out.println("carton");
		out.println("voila votre numero de carton monsieur "+string+":"+x);
		
		
	}



	public void sendLogin() {
		out.println("login");
		out.println("rentré votre login");
		
	}



	public void Num() {
		NbrRandom ++;
		int n = NbrRandom -1;
		if(NbrRandom <91) {
			out.println("num");
			 out.println(""+SocketServer.NumLancer.get(n));
		 }else {
			 out.println("quit");
			 //Input.stop = true;
			 NbrRandom = 0;
		 }
		 }



	public void quit() {
		
		out.println("quit");
		// TODO Auto-generated method stub
		
	}



	public void gagne() {
		// TODO Auto-generated method stub
		out.println("felicitations  "+Input.s+"  vous avez gagner");
		
	}
		
	}

