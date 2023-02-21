/**
 * 자바 퀴즈 1-1 CLASS
 * @author tjral
 *
 */
public class Q11 {
	
	/**
	 * this method inputs two integer arguments, adds them, and return the summation.
	 * @param n
	 * @param m
	 * @return
	 */
	public static int sum(int n, int m) {
		return n + m;
	}
	
	/**
	 * main 메소드...
	 * @param args
	 */
	// main() 메소드에서 실행 시작
	public static void main(String[] args) { 
		int i = 20;
		int s;
		char a;

		s = sum(i, 10);	// 메소드 호출
		a = '?';
		System.out.println("석민규 19011447");
		System.out.println(a);		 // 문자 '?' 출력
		System.out.println("Hello"); // "Hello" 문자열 출력
		System.out.println(s);		 // 정수 s 값 30 출력
	}
}
