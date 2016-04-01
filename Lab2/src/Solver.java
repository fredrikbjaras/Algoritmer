import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solver {
	////// DIRECTED GRAPHS!!!///////
	//
	//
	//
	//
	//
	//
	//
	// !!
	//

	private Scanner scan;
	private String target;
	private HashMap<String, ArrayList<String>> graph;
	private ArrayDeque<String> que;
	private boolean state;
	private int dist = 0;

	public Solver(String path, HashMap<String, ArrayList<String>> graph) {
		this.graph = graph;
		try {
			scan = new Scanner(new File(path));
			parseInput();
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	private void parseInput() {
		while (scan.hasNextLine()) {
			String root = scan.next();
			target = scan.next();
			que = new ArrayDeque<String>();
		}
	}

	////// DIRECTED GRAPHS!!!///////
	//
	//
	//
	//
	//
	//
	//
	// !!
	//
	private void solve(String node) {
		que.add(node);
		while (!que.isEmpty()) {
			ArrayList<String> list = graph.get(que.poll());
			int size = list.size();
			for (String string : list) {
				que.add(string);
			}
		}
	}
}
