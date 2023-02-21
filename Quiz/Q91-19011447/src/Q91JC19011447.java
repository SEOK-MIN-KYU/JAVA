import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Q91JC19011447 extends JFrame {
	public Q91JC19011447() {
		setTitle("퀴즈 9-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		JButton btn2 = new JButton("Stop");
		btn2.addActionListener(new MyActionListener2());
		c.add(btn2);
		
		
		setSize(350, 150);
		setVisible(true);

	}
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action")) 
				b.setText("액션");
			else 
				b.setText("Action");
			
			Q91JC19011447.this.setTitle(b.getText());
		}
	}	
	private class MyActionListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Stop")) 
				b.setText("스톱");
			else 
				b.setText("Stop");
			
			Q91JC19011447.this.setTitle(b.getText()); 
		}
	}	
	public static void main(String[] args) {
		new Q91JC19011447();
	}
}
