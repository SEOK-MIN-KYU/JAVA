class Sample {
	public int a;
	private int b;
	int c;
	
	void setB (int bb) {
		b=bb;
	}
	int getB() {
		return b;
	}
}
public class Q41JC19011447 {

	public static void main(String[] args) {

		System.out.println("석민규 19011447");
		Sample sample = new Sample();
		a = Sample.setB(10);
		b = Sample.setB(20);
		c = Sample.setB(30);
		
		System.out.print(getB(a));
		System.out.print(getB(b));
		System.out.print(getB(c));
		
	}

}
