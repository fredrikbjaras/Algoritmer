
public class Edge extends Node{

	private String origin;
	public Edge(String name,String origin, int distance) {
		super(name, distance);
		this.origin = origin;
	}
	public String getOrgin(){
		return origin;
	}
	
	@Override
	public boolean equals(Object node){
			if(((Node) node).getName().compareTo(name) == 0){
				return true;
			}
		return false;
	}
}
