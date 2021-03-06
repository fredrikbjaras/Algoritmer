import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	public HashMap<Integer, Point> parse(){
		if(scan.nextLine().contains("NAME")){
			while(!scan.nextLine().contains("NODE_COORD_SECTION")){
			}
		}
		ArrayList<Point> points = new ArrayList<Point>();
		String index = scan.next();
		while(scan.hasNextLine() && !index.equals("EOF")){
			points.add(new Point(index, Double.parseDouble(scan.next()), Double.parseDouble(scan.next())));
			if(scan.hasNext()){
				index = scan.next();
			}else{
				index = "EOF";
			}
		}
		points.sort(null);
		HashMap<Integer, Point> sorted = new HashMap<Integer, Point>();
		for(int i = 0; i < points.size(); i++){
			sorted.put(i, points.get(i));
		}
		return sorted;
	}

}
