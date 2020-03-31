import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Carton extends JPanel implements ActionListener, MouseListener{
	JPanel j;
	int idf;
	int caseVide ;
	 int bout;
	//JPanel j1;
	 JFrame frame4 = new JFrame();
	 JPanel jp = new JPanel();
	ArrayList<Integer> NumCarton = new ArrayList<Integer>();
	
	static ArrayList<JButton> l ;
	
	
	
public Carton (int i) {

	  j= new JPanel();   
	  idf = i;
	JFrame frame = new JFrame();
         
     l=new ArrayList<JButton>();
     frame.setVisible(true);
     frame.setSize(900, 350);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setContentPane(this);
  
     
     

}
     
     public void paint (Graphics g) {
    		super.paint(g);
    		int height = 900;
    		int width = 500;
    		this.setLayout(null);
    		
     for(int i=0;i<3;i++) {
    	 for(int j=0;j<9;j++) {
    	
    	
    	 JButton l1= new JButton();
    	 l1.setVisible(true);
    	 Font font = new Font("Arial",Font.BOLD,20);
    	 l1.setFont(font);
    	
		if(caseVide(bout)) {
    	 l1.addMouseListener(this);}
		bout++;
    	l1.setBounds(j*100, i*100,100 , 100);
    	l1.setVisible(true);
    	 Random rand = new Random();
    	 
    	
    			int r = rand.nextInt(90)+1;
    			while(NumCarton.contains(r)) {
    				r = rand.nextInt(90);
    			};
    			NumCarton.add(r);
    			if(caseVide(caseVide)) {
    	 l1.setText(""+r);}
    			caseVide++;
    	
    	 l1.setHorizontalAlignment(SwingConstants.CENTER); 
    	 l.add(l1);
    	
    	 this.add(l1);
    	
         
         
     }}
     
     
     
         	

    
}
public static boolean ListVide() {
	for(int i = 0;i<l.size();i++) {
		if(caseVide(i)) {
		if(l.get(i).getText()!="0") {
		
			return false;
			
		
	}}}
	return true;
}
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0;i<l.size();i++) {
		if(l.get(i)==e.getSource()) {
			if(Input.verifie.contains(Integer.parseInt(l.get(i).getText()))) {
			l.get(i).setText("0");
			l.get(i).addMouseListener(null);}
			if(quine1()) {
				fenQuine(1);
			}
			if(quine2()) {
				fenQuine(2);
				
			}
			if(quine3()) {
				fenQuine(3);
			}
		}}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
public static boolean caseVide(int caseVide ) {
	if(caseVide == 0||caseVide == 2||
			caseVide == 4||caseVide == 6||
			caseVide == 8||caseVide == 9||
			caseVide == 11||caseVide == 13||
			caseVide == 15||caseVide == 17||
			caseVide == 18||caseVide == 20||
			caseVide == 22||caseVide == 24||
			caseVide == 26) { return true;}else {
				return false;
			}
	
}
public static boolean quine1() {
	for(int i = 0;i<9;i++) {
		if(caseVide(i)) {
		if(l.get(i).getText()!="0") {
			return false;
			
		
	}}}
	return true;
}
public static boolean quine2() {
	for(int i = 9;i<18;i++) {
		if(caseVide(i)) {
		if(l.get(i).getText()!="0") {
			return false;
			
		
	}}}
	return true;
}
public static boolean quine3() {
	for(int i = 18;i<27;i++) {
		if(caseVide(i)) {
		if(l.get(i).getText()!="0") {
			return false;
			
		
	}}}
	return true;
}
public void fenQuine (int i) {
	JButton b = new JButton ();
	jp.setLayout(null);
	frame4.setSize(400, 200);
	frame4.setLocation(500, 500);
	frame4.setResizable(false);
	frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame4.setVisible(true);
	frame4.setContentPane(jp);
	 Font font = new Font("Arial",Font.BOLD,10);
	 b.setFont(font);
	b.setBounds(25,25,200,100);
	b.setText("quine de la ligne :"+i);
	jp.add(b);
	
	
}
}

