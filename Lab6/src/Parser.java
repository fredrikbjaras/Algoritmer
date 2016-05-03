import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
	private Scanner scan;
	
	public Parser(String path){
		try {
			scan = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}
	
	public ArrayList<Arc> parse(){
		ArrayList<String> nodes = new ArrayList<String>();
		ArrayList<Arc> graph = new ArrayList<Arc>();
		
		for(int i = 0; i < scan.nextInt(); i++){
			nodes.add(scan.next());
		}
		
		for(int i = 0; i < scan.nextInt(); i++){
			graph.add(new Arc(nodes.get(scan.nextInt()),nodes.get(scan.nextInt()), scan.nextInt()));
		}
		
		return graph;
		
	}

}
