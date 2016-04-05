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
		while (scan.hasNextLine() && scan.hasNext()) {
			String root = scan.next();
			String target = scan.next();
			que = new ArrayDeque<String>();
			
			int temp = solve(root, target);
			if(temp > 0){
				System.out.println(temp);
			}else{
				System.out.println(-1);
			}
			
		}
	}

	private int solve(String root, String target) {
		lengthTo = new HashMap<String, Integer>();
		visited = new ArrayList<String>();
		visited.add(root);
		lengthTo.put(root, 0);
		que.push(root);
		while(!que.isEmpty()){
			String node = que.pop();
			for(String string : graph.get(node)){
				if(string == target){
					return lengthTo.get(node) + 1;
				}else if(!visited.contains(string)){
					lengthTo.put(string, lengthTo.get(node) + 1);
					visited.add(string);
					que.push(string);
				}
			}
		}
		return lengthTo.get(target);
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
