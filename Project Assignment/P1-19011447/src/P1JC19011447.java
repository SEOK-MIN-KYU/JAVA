import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.io.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;
import java.time.LocalDate;
class ReadText {
	File src;
	FileReader fr;
	BufferedReader bufReader;

	public ReadText (String fName) {
		src = new File("c:\\temp\\"+fName+".txt");//경로 설정 필요
		
		try {
			fr = new FileReader(src);
			bufReader = new BufferedReader(fr);

		} catch (FileNotFoundException fe) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("File Open Error!");
		}
	}
	public String readLine() {
		String line="";
		
		try {
			line= bufReader.readLine();
		} catch (IOException e) {
			System.out.println("File Read Error!");
		}
		return line;
	}
	
}
class WriteText{
	FileWriter fout;
	public WriteText(String fName, String s[], int i) {
		try {
			fout = new FileWriter("c:\\temp\\"+fName+".txt", true);//경로 설정 필요
			fout.write("\n" + s[0] + " " + s[1] + " " + Time() + " withdraw " + i);
			fout.close();
			System.out.println("Write : withdraw " + i);
		}
		catch (IOException e) {
			System.out.println("File Write Error!");
		}
	}
	public String Time() {
		String s;
		LocalDate today = LocalDate.now();
		s= today.toString();
		return s;
	}
}
class WriteText2{
	FileWriter fout;
	public WriteText2(String fName, String s[], int i) {
		try {
			fout = new FileWriter("c:\\temp\\"+fName+".txt", true);//경로 설정 필요
			fout.write("\n" + s[0] + " " + s[1] + " " + Time() + " deposit " + i);
			fout.close();
			System.out.println("Write : Deposit " + i);
		}
		catch (IOException e) {
			System.out.println("File Write Error!");
		}
	}
	public String Time() {
		String s;
		LocalDate today = LocalDate.now();
		s= today.toString();
		return s;
	}
}
class Login extends JFrame{
	private JTextField tf = new JTextField(20);
	private JLabel error= new JLabel();
	public String str[]= {"0", "0"};
	public String str1[] = {"0", "0"};
	public String str2[] = {"0", "0"};
	public Login() {
		setTitle("Login");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("계좌번호 비밀번호 입력"));
		c.add(tf);
		c.add(error);
		check();
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s[]= {"0", "0"};
				String  tokens[];
				String st = new String();
				JTextField t = (JTextField)e.getSource();
				st = t.getText();
				
				tokens = st.split(" ");
				s=tokens;
				if(s[0].equals(str[0])&&s[1].equals(str[1])) {
					new Home(0);
					error.setText("");
					System.out.println("Login 123-456-789");
				}
				else if(s[0].equals(str1[0])&&s[1].equals(str1[1])) {
					new Home(1);
					error.setText("");
					System.out.println("Login 123-456-788");
				}
				else if(s[0].equals(str2[0])&&s[1].equals(str2[1])) {
					new Home(2);
					error.setText("");
					System.out.println("Login 123-456-787");
				}
				else {
					error.setText("Incorrect Account numbers & Passwords");
					System.out.println("Incorrect Account numbers & Passwords");
				}
				t.setText("");
			}
		});
		setSize(300, 150);
		setVisible(true);
	}
	public void check() {
		ReadText rT = new ReadText("bankaccount");
		String line="";
		String tokens[];
		int i=0;
		while ((line = rT.readLine()) != null) {
			tokens = line.split(" ");
			if(i==0)
				str=tokens;
			else if (i==1)
				str1=tokens;
			else
				str2=tokens;
			i++;
		}
	}
}
class Simulation extends JFrame{
	public Simulation() {
		System.out.println("Simulation");
		setTitle("Simulation Result");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("Result"));
		
		setSize(300, 150);
		setVisible(true);
	}
}
class Home extends JFrame{
	public String str[]= {"0", "0", "0"};
	public String str1[] = {"0", "0", "0"};
	public String str2[] = {"0", "0", "0"};
	public String tmp[] = {"0", "0", "0"};
	public int i= 0;
	private JLabel money = new JLabel();
	public Home(int j) {
		i=j;
		setTitle("Home");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Balance");
		JButton btn2 = new JButton("Withdraw");
		JButton btn3 = new JButton("Deposit");
		btn.addActionListener(new MyActionListener());
		btn2.addActionListener(new MyActionListener2());
		btn3.addActionListener(new MyActionListener3());
		c.add(btn);
		c.add(btn2);
		c.add(btn3);
		c.add(money);
		setSize(280, 150);
		setVisible(true);
	}
	public void Balance(int j){
		if(j==0) {
			System.out.println("Current Balance : " + str2[1]);
			money.setText("Current Balance : " + str2[1]);
		}
		else if(j==1){
			System.out.println("Current Balance : " + str1[1]);
			money.setText("Current Balance : " + str1[1]);
		}
		else if(j==2){
			System.out.println("Current Balance : " + str[1]);
			money.setText("Current Balance : " + str[1]);
		}
	}
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			check(i);
			Balance(i);
		}
	}
	private class MyActionListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Withdraw(i);
			money.setText("");
		}
	}
	private class MyActionListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Deposit(i);
			money.setText("");
		}
	}
	public void check(int j) {
		ReadText rT = new ReadText("transactions");
		String line="";
		String tokens[];
		int i=0;
		while ((line = rT.readLine()) != null) {
			tokens = line.split(" ");
			if(i==0)
				str=tokens;
			else if (i==1)
				str1=tokens;
			else if(i==2)
				str2=tokens;
			else if(i>5) {
				tmp=tokens;
				if(str2[0].equals(tmp[0]))
					str2[1] = tmp[1];
				else if(str1[0].equals(tmp[0]))
					str1[1] = tmp[1];
				else
					str[1] = tmp[1];
			}
			i++;
		}
	}
}
class Withdraw extends JFrame{
	public String str[]= {"0", "0", "0"};
	public String str1[] = {"0", "0", "0"};
	public String str2[] = {"0", "0", "0"};
	public String tmp[] = {"0", "0", "0"};
	public int i=0;
	public int money = 0;
	private JTextField tf = new JTextField(20);
	private JTextField tf2 = new JTextField(20);
	private JLabel error = new JLabel();
	private JLabel err = new JLabel();
	public Withdraw(int j) {
		i=j;
		setTitle("Withdraw");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("비밀번호"));
		c.add(tf);
		c.add(new JLabel("출금액"));
		c.add(tf2);
		c.add(error);
		c.add(err);
		tf2.setEnabled(false);
		check(i);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st = new String();
				JTextField t = (JTextField)e.getSource();
				st = t.getText();
				if(st.equals(Password())) {
					System.out.println("Correct Password");
					tf2.setEnabled(true);
					error.setText("Correct Password!");
				}
				else {
					System.out.println("Incorrect Password");
					error.setText("Incorrect Password");
				}
				t.setText("");
			}
		});
		tf2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n;
				error.setText("");
				String st = new String();
				JTextField t = (JTextField)e.getSource();
				st = t.getText();
				enter(st);
				t.setText("");
			}
		});
		setSize(280, 150);
		setVisible(true);
	}
	public String Password() {
		String s = "?";
		if(i==0)
			s="9999";
		else if (i==1)
			s="8888";
		else if(i==2)
			s= "7777";
		return s;
	}
	public int enter(String st) {
		int m = Integer.parseInt(st);
		int n = 0;
		if(i==0)
			n= Integer.parseInt(str2[1]);
		else if(i==1)
			n= Integer.parseInt(str1[1]);
		else if(i==2)
			n= Integer.parseInt(str[1]);
		if(m>n) {
			System.out.println("Lack of balance");
			err.setText("Lack of balance");
		}
		else {
			err.setText("Wihtdraw " + m);
			if(i==0) {
				str2[1]= Integer.toString(n-m);
				new WriteText("transactions", str2, m);
			}
			else if(i==1) {
				str1[1]= Integer.toString(n-m);
				new WriteText("transactions", str1, m);
			}
			else if(i==2) {
				str[1]= Integer.toString(n-m);
				new WriteText("transactions", str, m);
			}
		}
		return n;
	}
	public void check(int j) {
		ReadText rT = new ReadText("transactions");
		String line="";
		String tokens[];
		int i=0;
		while ((line = rT.readLine()) != null) {
			tokens = line.split(" ");
			if(i==0)
				str=tokens;
			else if (i==1)
				str1=tokens;
			else if(i==2)
				str2=tokens;
			else if(i>5) {
				tmp=tokens;
				if(str2[0].equals(tmp[0]))
					str2[1] = tmp[1];
				else if(str1[0].equals(tmp[0]))
					str1[1] = tmp[1];
				else
					str[1] = tmp[1];
			}
			i++;
		}
	}
}
class Deposit extends JFrame{
	public String str[]= {"0", "0", "0"};
	public String str1[] = {"0", "0", "0"};
	public String str2[] = {"0", "0", "0"};
	public String tmp[] = {"0", "0", "0"};
	public int i = 0;
	private JLabel Dep = new JLabel();
	private JTextField tf = new JTextField(20);
	public Deposit(int j) {
		i=j;
		setTitle("Deposit");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("금액을 입력하시오"));
		c.add(tf);
		c.add(Dep);
		check2(i);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n;
				String st = new String();
				JTextField t = (JTextField)e.getSource();
				st = t.getText();
				enter(st);
				t.setText("");
			}
		});
		setSize(350, 150);
		setVisible(true);
	}
	public void sleep() {
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException a) {
			return;
		}
	}
	public int enter(String st) {
		int m = Integer.parseInt(st);
		int n = 0;
		if(i==0)
			n= Integer.parseInt(str2[1]);
		else if(i==1)
			n= Integer.parseInt(str1[1]);
		else if(i==2)
			n= Integer.parseInt(str[1]);
		Dep.setText("Deposit " + m);
		if(i==0) {
			str2[1]= Integer.toString(n+m);
			new WriteText2("transactions", str2, m);
		}
		else if(i==1) {
			str1[1]= Integer.toString(n+m);
			new WriteText2("transactions", str1, m);
		}
		else if(i==2) {
			str[1]= Integer.toString(n+m);
			new WriteText2("transactions", str, m);
		}
			
		sleep();
		return n;
	}
	public void check2(int j) {
		ReadText rT = new ReadText("transactions");
		String line="";
		String tokens[];
		int i=0;
		while ((line = rT.readLine()) != null) {
			tokens = line.split(" ");
			if(i==0)
				str=tokens;
			else if (i==1)
				str1=tokens;
			else if(i==2)
				str2=tokens;
			else if(i>5) {
				tmp=tokens;
				if(str2[0].equals(tmp[0]))
					str2[1] = tmp[1];
				else if(str1[0].equals(tmp[0]))
					str1[1] = tmp[1];
				else
					str[1] = tmp[1];
			}
			i++;
		}
	}
}
public class P1JC19011447 extends JFrame{
	public P1JC19011447() {
		setTitle("ATM Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Login");
		JButton btn2 = new JButton("Simulation");
		btn.addActionListener(new MyActionListener());
		btn2.addActionListener(new MyActionListener2());
		c.add(btn);
		c.add(btn2);
		
		setSize(350, 150);
		setVisible(true);

	}	
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Login();
		}
	}	
	private class MyActionListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Simulation();
		}
	}	
	public static void main(String[] args) {
		System.out.println("19011447 Seok Min Kyu");
		System.out.println("Welcome!");
		new P1JC19011447();
	}
}
