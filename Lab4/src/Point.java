
public class Point implements Comparable<Point>{
	private String name;
	private double x;
	private double y;
	
	public Point(String name, double x, double y){
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public double distance(Point point){
		double xDiff = point.getX() - x;
		double yDiff = point.getY() - y;
		return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public int compareTo(Point o) {
		if(x < o.getX()){
			return -1;
		}else if (x == o.getX()){
			return 0;
		}
		return 1;
	}


}
