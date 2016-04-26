import java.util.ArrayList;

public class ClosestPoint {

	public static void main(String[] args) {
		Solver solver = new Solver();
		for (int i = 0; i < args.length; i++) {
			Parser parse = new Parser(args[i]);
			int temp = args[i].lastIndexOf("/");
			String path = args[i].substring(temp + 1);
			path = "../data/" + path + ": ";
			System.out.print(path);
			ArrayList<Point> points = parse.parse();
			System.out.print(points.size() + " ");
			solver.solve(points);
		}

	}

}
