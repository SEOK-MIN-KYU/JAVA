import java.awt.*;
import javax.swing.*;

class TimerRunnable implements Runnable {
	private JLabel timerLabel; // 타이머 값이 출력된 레이블
	
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel; // 초 카운트를 출력할 레이블
	}
	
	// 스레드 코드. run()이 종료하면 스레드 종료
	@Override
	public void run() {
		int n=0; // 타이머 카운트 값
		while(true) { // 무한 루프
			timerLabel.setText(Integer.toString(n)); // 레이블에 카운트 값 출력
			n++; // 카운트 증가
			try {
				Thread.sleep(1000); // 1초동안 잠을 잔다.
			}
			catch(InterruptedException e) {
				return; // 예외가 발생하면 스레드 종료
			}
		}
	}
}
class TimerRunnable2 implements Runnable {
	private JLabel timerLabel; // 타이머 값이 출력된 레이블
	private int maxNum = 100;
	public TimerRunnable2(JLabel timerLabel, int mN) {
		this.timerLabel = timerLabel; // 초 카운트를 출력할 레이블
		maxNum = mN;
	}
	
	// 스레드 코드. run()이 종료하면 스레드 종료
	@Override
	public void run() {
		int n=maxNum; // 타이머 카운트 값
		while(true) { // 무한 루프
			timerLabel.setText(Integer.toString(n)); // 레이블에 카운트 값 출력
			n--; // 카운트 증가
			try {
				Thread.sleep(1000); // 1초동안 잠을 잔다.
			}
			catch(InterruptedException e) {
				return; // 예외가 발생하면 스레드 종료
			}
		}
	}
}
public class Q112JC19011447 extends JFrame{
	JLabel timerLabel = new JLabel();
	JLabel tl2 = new JLabel();
	public Q112JC19011447() {
		setTitle("19011447 Seok Min Kyu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		c.setLayout(null);
		// 타이머 값을 출력할 레이블 생성
		//JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		tl2.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		timerLabel.setLocation(10, 10);
		timerLabel.setSize(100, 100);
		tl2.setLocation(10, 100);
		tl2.setSize(100, 100);
		
		c.add(timerLabel); // 레이블을 컨텐트팬에 부착
		c.add(tl2);
		
		// 타이머 스레드로 사용할 Runnable 객체 생성. 타이머 값을 출력할 레이블을 생성자에 전달
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable); // 스레드 객체 생성
		TimerRunnable2 runnable2 = new TimerRunnable2(tl2, 100);
		Thread th2 = new Thread(runnable2); // 스레드 객체 생성
		
		setSize(250,350);
		setVisible(true);
		
		th.start(); // 타이머 스레드가 실행을 시작하게 한다.
		th2.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Q112JC19011447();
	}
}
