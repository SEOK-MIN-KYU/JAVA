import java.util.Scanner;

public class Q31 {

	public static void main(String[] args) {
		int n, sum = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("19011447 석민규");
		n = scanner.nextInt();
		if(n<=0)
			System.out.println("input error!");
		else {
			for(int i=1;i<=n;i++) {
				sum += i;
				System.out.print(i);
				
				if(i<=n-1)
					System.out.print(" + ");
				else {
					System.out.print(" = ");
					System.out.println(sum);
				}
			}
		}
		scanner.close();
	}
}
