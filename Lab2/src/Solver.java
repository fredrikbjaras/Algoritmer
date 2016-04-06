import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solver {

	private Scanner scan;
	private HashMap<String, ArrayList<String>> graph;
	private ArrayDeque<String> que;
	private ArrayList<String> visited;
	private HashMap<String, Integer> lengthTo;

	public Solver(String path, HashMap<String, ArrayList<String>> graph) {
		this.graph = graph;
		try {
			scan = new Scanner(new File(path));
			parseInput();
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found eller bara ett random fel i hela resten av programmet!");
		}
	}

	private void parseInput() {
		while (scan.hasNextLine() && scan.hasNext()) {
			String root = scan.next();
			String target = scan.next();
			que = new ArrayDeque<String>();
			solve(root, target);
		}
	}

	private void solve(String root, String target) {
		boolean found = false;									
		int depth = 0;					
		if (root.compareTo(target) == 0) {						
			System.out.println(depth);
		} else {
			lengthTo = new HashMap<String, Integer>();
			visited = new ArrayList<String>();
			visited.add(root);
			lengthTo.put(root, 0);
			que.push(root);
			while (!found && !que.isEmpty()) {
				String node = que.poll();						
				for (String string : graph.get(node)) {			
					if (!visited.contains(string)) {			
						lengthTo.put(string, lengthTo.get(node) + 1);
						visited.add(string);
						que.addLast(string);																				
					}											
					if (string.compareTo(target) == 0) {		
						found = true;
						depth = lengthTo.get(target);
						break;									
					}											
				}																																	
			}
			if (depth == 0) {
				System.out.println("-1");						
			} else {											
				System.out.println(depth);
			}
		}
	}
}
