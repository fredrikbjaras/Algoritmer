
@SuppressWarnings("rawtypes")
public class Node implements Comparable{
	private int distance;
	private String name;
	public Node(String name, int distance){
		this.name = name;
		this.distance = distance;
	}
	
	public int getDist(){
		return distance;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public int compareTo(Object node) {
		if(node instanceof Node){
			if(((Node) node).getDist()> distance){
				return -1;
			}else if(((Node) node).getDist() == distance){
				return 0;
			}
		}
		return 1;
	}

}
