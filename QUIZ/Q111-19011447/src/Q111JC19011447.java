import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Q111JC19011447 extends JFrame{
	JTextField myT = new JTextField(20);
	JLabel myL = new JLabel();
	JPanel myP= new JPanel();
	public Q111JC19011447() {
		setTitle("19011447 Seok Min Kyu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		myP.setLayout(new GridLayout(3, 2));
		myP.add(new JLabel("이름 "));
		myP.add(myT); // 창의 열 개수 20
		myT.addActionListener(new MyActionListener());
		myP.add(new JLabel("학과 "));
		myP.add(new JTextField("컴퓨터공학과", 20)); // 창의 열 개수 20
		myP.add(new JLabel("주소 "));
		myP.add(new JTextField("서울시 ...", 20)); // 창의 열 개수 20
		
		c.add(myP, BorderLayout.CENTER);
		c.add(myL, BorderLayout.SOUTH);
		setSize(300,150);
		setVisible(true);
	}
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JTextField myTT = (JTextField)e.getSource();
			myL.setText(myTT.getText());
		}
	}
	public static void main(String[] args) {
		new Q111JC19011447();
	}

}
