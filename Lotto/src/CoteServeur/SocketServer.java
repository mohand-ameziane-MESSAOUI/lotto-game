package CoteServeur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SocketServer {
int port  = 1234;
Timer time= new Timer();
static int attJouer;
static boolean commence = false; 
ServerSocket serverSocket =null;
int NbrRandom;
Random r = new Random();
public static ArrayList <Integer> NumLancer = new ArrayList <Integer>();
public void runServer() {
	try {
		time.scheduleAtFixedRate(Tasktimer, 1000,1000);
		Construire();
		serverSocket = new ServerSocket(port);
	}catch(IOException e) {
	System.out.println(e.getMessage());
	}
	
	while(true) {
		try {
			Socket clientSocket = serverSocket.accept();
			HandleClient mr = new HandleClient(clientSocket); 
			new Thread (mr).start();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
	}
}


}
public void Construire(){
	for(int i =0;i<90;i++) {
	 while(!(NotExiste(NbrRandom))) {
		 NbrRandom = r.nextInt(91);
	 }
	 SocketServer.NumLancer.add(NbrRandom);
	}
}
public boolean NotExiste(int j) {
	for(int i=0;i<NumLancer.size();i++) {
		 if (j == NumLancer.get(i)) {
			 return false;
		 }
	 }
	return true;
}
TimerTask	Tasktimer = new TimerTask () {
	  @Override
	  public void run() {
		  if(attJouer<60) {attJouer++;}
		  else {
				commence = true;
		  }
	  }
	};
}
