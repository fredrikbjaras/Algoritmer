import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solver {
	private HashMap<String, ArrayList<Node>> graph;
	private HashMap<String, Integer> distList;
	private ArrayList<Node> nodeList;

	public Solver() {

	}

	public void solve(HashMap<String, ArrayList<Node>> graph) {
		this.graph = graph;
	}

	private void prim(){
		nodeList = new ArrayList<Node>();
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		
		String temp = (String) graph.keySet().toArray()[0];
		distList = new HashMap<String, Integer>();
		for(String city: graph.keySet()){
				distList.put(city, Integer.MAX_VALUE);
		}
		distList.put(temp, 0);
		
		for(Node node: graph.get(temp)){
			que.add(node);
		}
		
		while(!que.isEmpty()){
			Node current = que.remove();
			for(Node node: graph.get(current.getName())){
				if(que.contains(node) && node.getDist() < distList.get(node.getName())){
					
				}
			}
		}
		
	}

}
