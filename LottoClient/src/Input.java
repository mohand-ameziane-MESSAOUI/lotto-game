import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Input {
	Client handler;
	InputStream in;
	static int commence = 0;
	Timer timer = new Timer();
	static ArrayList verifie = new ArrayList();
	static String login;

	int tim;
	static int q = 0;
	boolean stop = false;

	public Input(InputStream in, Client client) throws IOException {
		this.in = in;
		this.handler = client;
	}

	TimerTask Tasktimer = new TimerTask() {
		@Override
		public void run() {
			if (!(Client.g.gagne()) && tim < 90) {
				
				Game.ButtonLancer.setText("" + Game.NumLotto.get(tim));
				verifie.add(Game.NumLotto.get(tim));
				tim++;
			} else {
				q = 1;
				
				timer.cancel();
			}
		}
	};

	public void doRun() throws Exception {
		// TODO Auto-generated method stub
		
		String message;
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {

			Game.Attente_auth();
			handler.sendLogin();
			while (!stop) {
			
				String line = is.readLine();
				if (line == null) {

					throw new Exception("Invalid input");
				}

				switch (line) {
				case "login":
					Game.txt.setText(is.readLine());
					handler.sendLogin();
					break;

				case "carton":
					String t = is.readLine();
					// String t=is.readLine();

					Game.txt2.setText(t);
					handler.sendNum();
					break;
				case "quit":
					
					handler.quit();
					stop = true;

					break;
				case "num":
					String l = is.readLine();
					System.out.println("je suis la");
					if (Game.NumLotto.size() < 90) {
						Game.NumLotto.add(Integer.parseInt(l));
						// String t=is.readLine();
						handler.sendNum();
					}

					break;

				}
			}
			while (commence == 0) {
				System.out.println("attente commencer");
				;
			}

			timer.scheduleAtFixedRate(Tasktimer, 2000, 2000);

		
			String t = null;
			while (!(Client.g.gagne()) && tim < 90) {
				
				System.out.println("attente de timer");
			}

			if (q != 0) {
				System.out.println("jai gagner");
				handler.sendgagne();
				fenGagne(is.readLine());
			} else {
				System.out.println("jai pa gagner");
				fenGagne("dommage un autre joueur a gagner");

			}

		}

	}

	public void fenGagne(String s) {
		JButton ButtonG = new JButton("");
		JPanel j = new JPanel();
		j.setLayout(null);
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setContentPane(j);
		Font font = new Font("Arial", Font.BOLD, 20);
		ButtonG.setFont(font);
		ButtonG.setBounds(50, 50, 400, 100);
		ButtonG.setText(s);
		j.add(ButtonG);
	}
}
/*
 * 
 * System.out.println("quiiiiiiiiiiiiiiittteee2"); while(commence==0)
 * {System.out.println("coucou");;}
 * 
 * timer.scheduleAtFixedRate(Tasktimer, 500,500); String t=is.readLine();
 * System.out.println("informationnnnnn"+y+"et"+t); while(y==0&&t==null) {
 * t=is.readLine(); System.out.println("coucou");}
 * System.out.println("informationnnnnn"+y+"et"+t); if(this.y!=0) {
 * System.out.println("jai gagner avec y = 1"); handler.sendgagne();
 * fenGagne(is.readLine());} else { System.out.println("jai gagner avec y = 0");
 * fenGagne(t);
 */
