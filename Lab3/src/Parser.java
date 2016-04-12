import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {
	private Scanner scan;
	private String path;
	private HashMap<String, ArrayList<Node>> graph;

	public Parser(String path) {
		try {
			scan = new Scanner(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	public void parseInput() {
		graph = new HashMap<String, ArrayList<Node>>();
		String line = scan.nextLine();
		while (!line.endsWith("]")) {
			line = line.replaceAll("\"", "");
			line = line.substring(0,line.length()-1);
			graph.put(line, new ArrayList<Node>());
			line = scan.nextLine();
		}

		while (scan.hasNextLine() && line != "") {
			line = line.replaceAll("\"", "");
			String[] temp = line.split("--");
			String from = temp[0];
			temp = temp[1].split("\\[");
			String dest = temp[0];
			String dist = temp[1].replaceAll("]", "");
			int d = Integer.parseInt(dist);
			graph.get(from).add(new Node(dest, d));
			line = scan.nextLine();
		}
	}

}
