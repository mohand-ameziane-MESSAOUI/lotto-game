package CoteServeur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TimerTask;

public class Input {
	HandleClient handler; 
	InputStream in;
	int i ;
	static int mmNom;
	static String s;
	ArrayList client = new ArrayList();
	 boolean stop = false;

	public Input(InputStream in, HandleClient handler) throws IOException {
		this.in = in;
		this.handler = handler;
	}

	@SuppressWarnings("unused")
	public void doRun() throws Exception {
		String message, name, destinataire, room, FName;

		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			
			while (!stop) {
				
			
				String line = is.readLine(); 
				if (line == null) {
					throw new Exception("Invalid input");}
					
				switch (line) {
				case "login":
					String s = is.readLine();
					if(client.contains(s)) {
						mmNom++;
						client.add(s+""+mmNom);
					}else {
					client.add(s);}
					
					System.out.println("jai recu le login"+s);
					handler.sendCarton(s);
				
					break;
				case "quit":
              	  System.out.println("quiiiiiiiiiiiiiittteeeee");
              	 // handler.quit();
					stop=true;
					
				
					break;
				
				
					
				default:
				case "num":
					i++;
					while(SocketServer.commence==false)
					{System.out.println("attente go");}
					if(is.readLine()=="ok")
					//String t=is.readLine();
							System.out.println("jai recu le ok de client pour envoyé un numm");
					//if(i <89) {
					handler.sendNum();
					
					break;
					//handler.sendEror("");
					// throw new ChatProtocolException("Invalid input");

			}
		}
			s=is.readLine();
			while(s==null) {
				System.out.println("mazale");
				s=is.readLine();
			}
			System.out.println("ya quelqu'un qui a gagner"+s);
			handler.gagne();
			}
		}
	
	}

