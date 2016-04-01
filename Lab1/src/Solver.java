
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Solver {
	private ArrayList<Integer>[] men;
	private ArrayList<Integer>[] women;
	private String[] names;
	private BufferedReader br;
	private int[] matchesF;
	private int[] matchesM;
	private int engaged = 0;
	private int n;
	private ArrayDeque<Integer> singles;

	public Solver(String fileInput) {
		try {
			br = new BufferedReader(new FileReader(fileInput));
			parseInput();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	@SuppressWarnings("resource")
	private void parseInput() throws IOException {
		String string = br.readLine();
		while (string.startsWith("#")) {
			string = br.readLine();
		}
		Scanner scan = new Scanner(string);
		scan.skip("n=");
		n = scan.nextInt();
		men = new ArrayList[n];
		women = new ArrayList[n];
		names = new String[2 * n];
		matchesF = new int[n];
		matchesM = new int[n];
		singles = new ArrayDeque<Integer>();

		for (int i = 0; i < (n * 2); i++) {
			scan = new Scanner(br.readLine());
			scan.next();
			names[i] = scan.next();
		}
		for (int i = 0; i < n; i++) {
			singles.add(i);
		}
		br.readLine();
		for (int i = 0; i < n; i++) {
			scan = new Scanner(br.readLine());
			scan.next();
			ArrayList<Integer> mList = new ArrayList<Integer>();
			ArrayList<Integer> fList = new ArrayList<Integer>();
			while (!scan.hasNext(((i + 1) * 2) + ":") && scan.hasNext()) {
				mList.add(scan.nextInt());
			}
			scan = new Scanner(br.readLine());
			scan.next();
			while (!scan.hasNext((((i + 1) * 2) + 1) + ":") && scan.hasNext()) {
				fList.add(scan.nextInt());
			}
			men[i] = mList;
			women[i] = fList;
		}
		scan.close();
	}

	public void solve() {
		while (!singles.isEmpty()) {
			int man = singles.pop();
			propose(man);
		}

	}

	private void propose(int man) {
		for (int i = 0; i < men[man].size(); i++) {
			int woman = (men[man].get(i) / 2) - 1;
			if (matchesM[man] != 0) {
				break;
			} else if (!isEngaged(woman)) {
				matchesF[woman] = man + 1;
				men[man].remove(i);
				matchesM[man] = woman + 1;
				break;
			} else if (preffersM(woman, man)) {
				singles.add(matchesF[woman] - 1);
				matchesM[matchesF[woman] - 1] = 0;
				matchesF[woman] = man + 1;
				matchesM[man] = woman + 1;
				men[man].remove(i);
				break;
			}
			singles.add(man);
		}
	}

	private boolean isEngaged(int woman) {
		if (matchesF[woman] == 0) {
			return false;
		}
		return true;
	}

	private boolean preffersM(int woman, int m) {
		for (int temp : women[woman]) {
			temp = (temp / 2);
			if (temp == m) {
				return true;
			} else if (temp == matchesF[woman] - 1) {
				return false;
			}
		}
		return false;
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(names[i * 2] + " -- " + names[(matchesM[i] * 2) - 1]);
		}
	}
}