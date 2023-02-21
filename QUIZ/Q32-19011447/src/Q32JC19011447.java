
public class Q32JC19011447 {

	public static void main(String[] args) {
		
		int intArray[][];
		int d1, d2, sum;
		d1=Integer.parseInt(args[0]);
		d2=Integer.parseInt(args[1]);
		intArray = new int[d1][d2];
		
		for (int i=0; i<intArray.length; i++) {
			for (int j=0; j<intArray[i].length; j++)
				intArray[i][j] = (int)(Math.random()*100+1);
		}
		System.out.println("19011447 석민규");
		for (int i=0; i<intArray.length; i++) {
			sum=0;
			for (int j=0; j<intArray[i].length; j++) {
				sum+=intArray[i][j];
				System.out.print(intArray[i][j]);
				if(j<intArray[i].length-1)
					System.out.print(" + ");
			}
			System.out.println(" = " + sum);
		}
	}

}
