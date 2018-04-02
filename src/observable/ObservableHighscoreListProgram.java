package observable;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {
	
	private ObservableHighscoreList list;
	
	public void init() {
		list = new ObservableHighscoreList(10);
		list.addObservableListListener(this);
		run();
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ADD SCORES:");
		while(scanner.hasNextInt()) {
			int line = scanner.nextInt();
			list.addResult(line);
		}
	}
	
	
	@Override
	public void listChanged(ObservableList list, int position) {
		System.out.println("Changed pos: " + position);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		HighscoreListProgram p = new HighscoreListProgram();
		p.init();
	}
}
