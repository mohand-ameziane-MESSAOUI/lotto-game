

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel implements ActionListener {
	static int auth=0;
	static int auth2=0;
	JFrame frame2 ;
	static JButton ButtonLancer= new JButton("");
	 JPanel panel1 = new JPanel();
	 JPanel panel2 = new JPanel();
	public static JTextField txt = new JTextField("",30);
	public static JTextField txt2 = new JTextField("",30);
	static ArrayList<Integer> NumLotto = new ArrayList<Integer>();
	
	static JButton b =new JButton();
	static JButton b1 =new JButton();
	public Game() {
		Carton1();
	}
	public void paint() {
		
	}
	public void Carton1 () {
		

		frame2 = new JFrame();
		frame2.setSize(500, 500);
		frame2.setLocation(100, 100);
		frame2.setResizable(false);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
		frame2.setContentPane(panel1);
		panel1.setLayout(null);
		panel1.add(txt);
		
		b.setVisible(true);
		b.setText("login");
		b.setBounds(100, 120, 200,40);
		b.addActionListener(this);
		panel1.add(b);
		b1.setVisible(true);
		b1.setText("commencé");
		b1.setBounds(100, 310, 200, 40);
		b1.addActionListener(this);
		txt.setBounds(10,60,450,40);
		txt2.setBounds(10,250,450,40);
		
		panel1.add(txt2);
		panel1.add(b1);
	}
	public void Carton2 () {
		
		panel2.setLayout(null);
		JFrame frame1 = new JFrame();
		frame1.setSize(200, 200);
		frame1.setLocation(900, 100);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		frame1.setContentPane(panel2);
		 Font font = new Font("Arial",Font.BOLD,20);
		 ButtonLancer.setFont(font);
		ButtonLancer.setBounds(25,25,100,200);
		panel2.add(ButtonLancer);
		
		
	}
	public static void Attente_auth() {
		while(auth != 1) {
			System.out.println("attente");
		};
	}
	public void Attente_commence() {
		while(this.auth2 != 1) {
			System.out.println("attente");
		};
	}
	public synchronized boolean gagne() {
		if (Carton.ListVide()) {
			Input.q = 1;
			return true;}
		return false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b)
		{auth=1;
			
		}
		if(e.getSource()==b1)
		{
			auth2=1;
			Input.commence=1;
			Carton car= new Carton(ClientMain.numC);
			Carton2();
			frame2.dispose();
		}
		
	}
}
