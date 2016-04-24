import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
	private Scanner scan;
	
	public Parser(String path){
		try {
			System.out.println("PATH: " + path);
			scan = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}
	
	public ArrayList<Point> parse(){
		if(scan.nextLine().contains("NAME")){
			while(!scan.nextLine().equals("NODE_COORD_SECTION")){
			}
		}
		ArrayList<Point> points = new ArrayList<Point>();
		String index = scan.next();
		while(scan.hasNextLine() && !index.equals("EOF")){
			points.add(new Point(index, Double.parseDouble(scan.next()), Double.parseDouble(scan.next())));
			index = scan.next();
		}
		points.sort(null);
		return points;
	}

}
