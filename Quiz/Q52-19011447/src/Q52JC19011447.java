
class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}

	public boolean equals(Point p) {
		Point po = (Point)p;
		if(x == po.x && y == po.y)
			return true;
		else
			return false;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
	public double euclidDistance(Point p) {
		Point po=(Point)p;
		return Math.sqrt(Math.pow(x-po.getX(),2) + Math.pow(y-po.getY(),2));
	
	}
}
public class Q52JC19011447 {
	
	public static void main(String [] args) {
		System.out.println("19011447 석민규");
		Point p = new Point(3, 40);
		Point q = new Point(4, 50);
		System.out.println(p);
		System.out.println(q);
		if(p.equals(q)) System.out.println("Same point");
		else System.out.println("Diff point");
		System.out.println("Distance = "+p.euclidDistance(q));
	}
}