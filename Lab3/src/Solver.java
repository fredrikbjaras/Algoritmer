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
		PriorityQueue<Edge> que = new PriorityQueue<Edge>();
		ArrayList<Edge> route = new ArrayList<Edge>();
		ArrayList<String> marked = new ArrayList<String>();
		for(Node node: graph.get(root)){
			que.add(new Edge(node.getName(), root, node.distance));
		}
		
		marked.add(root);
		
		while(!que.isEmpty()){
			Edge shortest = que.remove();
			if(!marked.contains(shortest.getName())){
				marked.add(shortest.getName());
				route.add(shortest);
				for(Node node: graph.get(shortest.getName())){
					if(!marked.contains(node.getName())){
						que.add(new Edge(node.getName(), shortest.getName(), node.distance));
					}
				}
			}
		}
		
		int output = 0;
		for(Node node:route){
			output += node.getDist();
		}
		System.out.println(output);
		for(Edge edge:route){
			System.out.println(edge.getName() + "--" + edge.getOrgin());
		}
		
	}
}
