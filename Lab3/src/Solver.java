import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solver {
	private HashMap<String, ArrayList<Node>> graph;

	public void solve(HashMap<String, ArrayList<Node>> graph) {
		this.graph = graph;
		prim();
	}

	private void prim(){
		String root = (String) graph.keySet().toArray()[0];
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		ArrayList<Node> route = new ArrayList<Node>();
		ArrayList<String> marked = new ArrayList<String>();
		for(Node node: graph.get(root)){
			que.add(node);
		}
		
		marked.add(root);
		
		while(!que.isEmpty()){
			Node shortest = que.remove();
			if(!marked.contains(shortest.getName())){
				marked.add(shortest.getName());
				route.add(shortest);
				for(Node node: graph.get(shortest.getName())){
					if(!marked.contains(node.getName())){
						que.add(node);
					}
				}
			}
		}
		
		int output = 0;
		for(Node node:route){
			output += node.getDist();
		}
		System.out.println(output);
	}
}
