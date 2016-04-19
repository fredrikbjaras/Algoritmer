import java.util.ArrayList;

public class ClosestPoint {

	public static void main(String[] args) {
		Parser parse = new Parser(args[0]);
		Solver solver = new Solver();
		solver.solve(parse.parse());
		System.out.println("hej");

	}

}
