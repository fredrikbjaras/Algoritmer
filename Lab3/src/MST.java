
public class MST {
	public static void main(String[] args){
		System.out.println("Spanning USA!!!!");
		Parser parser = new Parser(args[0]);
		Solver solver = new Solver();
		solver.solve(parser.parseInput());
		System.out.println("Tiny EWG");
		parser = new Parser(args[1]);
		solver.solve(parser.parseInput());
	}

}
