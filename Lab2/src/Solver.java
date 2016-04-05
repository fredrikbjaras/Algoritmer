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
	private HashMap<String, ArrayList<String>> graph;
	private ArrayDeque<String> que;
	private boolean state;
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
			System.out.println("File not found");
		}
	}

	private void parseInput() {
		while (scan.hasNextLine()) {
			String root = scan.next();
			String target = scan.next();
			que = new ArrayDeque<String>();
			visited = new ArrayList<String>();
			solve(root);
			if(lengthTo.get(target) == null){
				System.out.println(-1);
			}else{
				System.out.println(lengthTo.get(target));
			}
			
		}
	}

	private void solve(String root) {
		lengthTo = new HashMap<String, Integer>();
		visited.add(root);
		lengthTo.put(root, 0);
		que.push(root);
		while(!que.isEmpty()){
			String node = que.pop();
			for(String string : graph.get(node)){
				if(!visited.contains(string)){
					lengthTo.put(string, lengthTo.get(node) + 1);
				}
			}
		}
//		if (!visited.contains(root)) {
//			que.add(root);
//			visited.add(root);
//			while (!que.isEmpty()) {
//				ArrayList<String> list = graph.get(que.pop());
//				int counter = 0;
//				for (String string : list) {
//					int temp = solve(, target, depth + 1);
//					if(temp < counter){
//						counter = temp;
//					}
//				}
//			}
//		}

	}

}
