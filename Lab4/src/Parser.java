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
	
	public ArrayList<Point> parse(){
		if(scan.nextLine().contains("NAME")){
			while(!scan.nextLine().equals("NODE_COORD_SECTION")){
			}
		}
		ArrayList<Point> points = new ArrayList<Point>();
		String line = scan.nextLine();
		while(scan.hasNextLine() && !line.equals("EOF")){
			String [] values = line.split(" ");
			points.add(new Point(values[0],Double.parseDouble(values[1]), Double.parseDouble(values[2])));
			line = scan.nextLine();
		}
		points.sort(null);
		return points;
	}

}
