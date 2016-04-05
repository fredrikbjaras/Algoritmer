import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Builder {
	private Scanner scan;
	private HashMap<String, ArrayList<String>> graph;

	public Builder(String path) {
		graph = new HashMap<String, ArrayList<String>>();
		try {
			scan = new Scanner(new File(path));
			parseInput();
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	public HashMap<String, ArrayList<String>> getGraph() {
		return graph;
	}

	private void parseInput() {
		while (scan.hasNext()) {
			ArrayList<String> tempList = new ArrayList<String>();
			String node = scan.next();
			for (String temp : graph.keySet()) {
				if (compareNodes(node, temp)) {
					tempList.add(temp);
				}
				if (compareNodes(temp, node)) {
					graph.get(temp).add(node);
				}
			}
			graph.put(node, tempList);

		}
	}

	private boolean compareNodes(String newString, String oldString) {
		char[] newArray = newString.toCharArray();
		char[] oldArray = oldString.toCharArray();
		int counter = 0;
		for (int i = newArray.length - 4; i < newArray.length; i++) {
			for (int j = 0; j < oldArray.length; j++) {
				if (newArray[i] == oldArray[j]) {
					counter++;
					oldArray[j] = ' ';
					j = oldArray.length;
				}
			}
		}
		if (counter == 4) {
			return true;
		}
		return false;
	}
}
