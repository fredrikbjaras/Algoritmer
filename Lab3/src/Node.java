
@SuppressWarnings("rawtypes")
public class Node implements Comparable{
	protected int distance;
	protected String name;
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
	
	@Override
	public boolean equals(Object node){
			if(((Node) node).getName().compareTo(name) == 0){
				return true;
			}
		return false;
	}

}
