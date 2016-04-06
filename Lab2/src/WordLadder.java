
public class WordLadder {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Builder builder = new Builder(args[0]);
		Solver solver = new Solver(args[1], builder.getGraph());
	}

}
