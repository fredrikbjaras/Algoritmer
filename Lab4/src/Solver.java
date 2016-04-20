import java.util.ArrayList;

public class Solver {
	private ArrayList<Point> list;

	public void solve(ArrayList<Point> list) {
		this.list = list;
		System.out.println(solve(0, list.size() - 1));
	}

	private double solve(int left, int right) {
		int mid = (left + right) / 2;
		if (right != left) {
			double midLine = ((list.get(mid).getX() + list.get(mid + 1).getX()))/2;
			double minLeft = solve(left, mid);
			double minRight = solve(mid + 1, right);
			double min;
			if (minLeft < minRight) {
				min = minLeft;
			} else {
				min = minRight;
			}

			int counter = mid;
			boolean state = false;
			while (!state) {
				if (midLine - list.get(counter).getX() > min) {
					left = counter + 1;
					state = true;
				}
				counter--;
				if(counter == left - 1){
					state = true;
				}
			}
			state = false;
			counter = mid + 1;
			while (!state) {
				if (list.get(counter).getX() - midLine > min) {
					right = counter - 1;
					state = true;
				}
				counter++;
				if(counter == right + 1){
					state = true;
				}
			}
			double middleMin = checkMin(sortByY(left, right));
			if (middleMin < min) {
				return middleMin;
			}
			return min;
		}
		return Double.MAX_VALUE;
	}

	private ArrayList<Point> sortByY(int left, int right){
		ArrayList<Point> yList = new ArrayList<Point>();
		yList.add(list.get(left));
		for(int i = left + 1; i < right + 1; i++){
			for(int j = yList.size()-1; j >= 0; j--){
				if(list.get(i).getY() > yList.get(j).getY()){
					yList.add(j + 1, list.get(i));
					break;
				}
				if(j == 0 && list.get(i).getY() < yList.get(j).getY()){
					yList.add(0, list.get(i));
				}
			}
		}
		return yList;
	}
	
	private double checkMin(ArrayList<Point> yList){
		double min = Double.MAX_VALUE;
		for(int i = 0; i < yList.size(); i++){
			for(int j = i + 1; (j < (i + 12)) && (j < yList.size()); j++){
				if(yList.get(i).distance(yList.get(j)) < min){
					min = yList.get(i).distance(yList.get(j));
				}
			}
		}
		return min;
	}

}
