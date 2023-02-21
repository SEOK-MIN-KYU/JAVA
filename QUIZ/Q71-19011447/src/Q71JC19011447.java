import java.io.*;

public class Q71JC19011447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("19011447 석민규");

		try {
			File file = new File("c:\\temp\\q71.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
			
			String line = "";
			String token[];
			int n, i1, i2;
			while((line = bufReader.readLine())!=null) {
				token = line.split(" ");
				
				i1 = Integer.parseInt(token[0]);
				i2 = Integer.parseInt(token[2]);
				System.out.print(line);
				if(token[1].equals("+")) {
					System.out.print(" = ");
					System.out.println(i1+i2);
				}
				else if (token[1].equals("-")) {
					System.out.print(" = ");
					System.out.println(i1-i2);
				}
				else if (token[1].equals("*")) {
					System.out.print(" = ");
					System.out.println(i1*i2);
				}
				else {
					System.out.print(" = ");
					System.out.println(i1/i2);
				}
				
			}
			bufReader.close();
		}
		catch(IOException e) {
			System.out.println("c:\\Temp\\test.out에서 읽지 못했습니다. 경로명을 체크해보세요");
		}
	}
}
