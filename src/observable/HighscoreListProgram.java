package observable;

import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener {
	
	private HighscoreList list;
	
	public void init() {
		this.list = new HighscoreList(10);
		this.list.addHighscoreListListener(this);
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
	public void listChanged(HighscoreList list, int position) {
		System.out.println("Changed pos: " + position);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		HighscoreListProgram p = new HighscoreListProgram();
		p.init();
	}

}
