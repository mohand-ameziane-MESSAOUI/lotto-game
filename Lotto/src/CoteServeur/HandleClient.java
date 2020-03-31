package CoteServeur;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;



public class HandleClient implements Runnable{

	protected Socket clientSocket = null;
	Scanner sc = new Scanner(System.in);
	//public ArrayList<String> ListCarton = new ArrayList <String>(10);
	String [] ListCarton= new String[10];
	public static int l;
	int NbrRandom;
	Input in;
	private  Socket s;
	Output out;
	boolean stop=false;
	Random r = new Random();
	String nameC;
	Timer timer = new Timer();
	public HandleClient(Socket clientSocket) {
		
		this.s = clientSocket;
	}
	

	public void run() {
		try (Socket s1 = s) {
			out = new Output(s1.getOutputStream());
			in = new Input(s1.getInputStream(), this);
			in.doRun();
		} catch (IOException ex) {
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendLogin() {
		
			out.sendLogin();
		
		}
	public void sendCarton(String string) {
		
		out.sendCarton(string);
	
	}


	public void sendEror(String string) {
		System.out.println("erreur");
		
	}

	public void sendNum() {
		
		out.Num();
		
	}

	public void quit() {
		out.quit();
		
	}

	public void gagne() {
		// TODO Auto-generated method stub
		out.gagne();
		
	}




}
