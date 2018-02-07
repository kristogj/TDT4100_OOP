package tictactoe;

public class TicTacToe {
	
	
	private String board = "         ";
	private char lastPlayer = 'O';
	
	public TicTacToe() {
		
	}
	
	public char getCell(int x, int y) {
		return this.board.charAt(x*3 + y - 4);
	}
	
	public boolean setCell(char c, int x, int y) {
		String legal = "XO";
		c = Character.toUpperCase(c);
		if(!isOccupied(x, y) && legal.indexOf(c) != -1) {
			this.board = this.board.substring(0,x*3 + y - 4) + c +  this.board.substring(x*3 + y - 3);
			this.lastPlayer = c;
			return true;
		}
		return false;
	}
	
	public boolean isOccupied(int x, int y) {
		return getCell(x, y) != ' ';
	}
	
	public char getCurrentPlayer() {
		return this.lastPlayer == 'O' ? 'X':'O';
	}
	
	
	
	
	@Override
	public String toString() {
		String str = "";
		for (int x = 1; x <= 3; x++) {
			for (int y = 1; y <= 3; y++) {
				str += " " + this.getCell(x, y) + " ";
			}
			str += "\n----------\n";
		}
		return str;
	}
	
	
	
	
	
	public static void main(String[] args) {
		TicTacToe tic = new TicTacToe();
		for(int x = 1; x < 4; x++) {
			for (int y = 1; y < 4; y++) {
				tic.setCell(tic.getCurrentPlayer(), x, y);
			}
		}
		System.out.println(tic);
		
		
		}
		
	

}
