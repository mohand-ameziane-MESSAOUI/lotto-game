import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Output {

	PrintWriter os;

	public Output(OutputStream out) throws IOException {
		this.os = new PrintWriter(out, true);
		
	}

	public void sendQuit() {
		// TODO Auto-generated method stub
		os.println("quit");
		
	}
	void Login() {
		
		os.println("login");
		os.println(Game.txt.getText());
		Input.login=Game.txt.getText();
	}
	
	public void sendEror(String string) {
		os.println("ERR");
		os.println(string);
	}

	public void Num() {
		os.println("Num");
		os.println("ok");
		
	}

	public void gagne() {
		
		os.println(""+Input.login);
		
	}

	
	
	
}
