import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable{
	Output out;
	Input in;
	private  Socket s;
	static Game g;
	public Client(Socket clientSocket) {
		s=clientSocket;
		g = new Game();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("je suis dans client");
		try (Socket s1 = s) {
			out = new Output(s1.getOutputStream());
			in = new Input(s1.getInputStream(), this);
			in.doRun();
		} catch (IOException e) {
				finish();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void finish() {
		// TODO Auto-generated method stub
		
	}
	public void sendLogin() {
		out.Login();
	}
	public void sendNum() {
		out.Num();
	}
	public void sendEror(String string) {
		// TODO Auto-generated method stub
		
	}
	public void sendgagne() {
		out.gagne();
		
	}
	public void quit() {
		// TODO Auto-generated method stub
		out.sendQuit();
		
	}
	
	

}
