package tictactoe;

public class TicTacToe {
	
	
	private String board;
	private char lastPlayer;
	
	public TicTacToe() {
		this.board = "         ";
		this.lastPlayer = 'O';
	}
	
	
	////////////// BOARDRULES //////////////
	
	public char getCell(int x, int y) {
		return this.board.charAt(x*3 + y - 4);
	}
	
	public boolean setCell(char c, int x, int y) {
		String legal = "XO";
		c = Character.toUpperCase(c);
		if(!isOccupied(x, y) && legal.indexOf(c) != -1 && !isFinished()) {
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
	
	////////////// LOGIC //////////////
	
	public void play(int x, int y) {
		setCell(getCurrentPlayer(), x, y);
	}
	
	private boolean checkRows(char c) {
		String f = "" + this.board.charAt(0) + this.board.charAt(1) + this.board.charAt(2);
		String s = "" + this.board.charAt(3) + this.board.charAt(4) + this.board.charAt(5);
		String t = "" + this.board.charAt(6) + this.board.charAt(7) + this.board.charAt(8);
		return f.matches("[" + c + "]*") || s.matches("[" + c + "]*") || t.matches("[" + c + "]*");
	}
	
	private boolean checkCols(char c) {
		String f = "" + this.board.charAt(0) + this.board.charAt(3) + this.board.charAt(6);
		String s = "" + this.board.charAt(1) + this.board.charAt(4) + this.board.charAt(7);
		String t = "" + this.board.charAt(2) + this.board.charAt(5) + this.board.charAt(8);
		return f.matches("[" + c + "]*") || s.matches("[" + c + "]*") || t.matches("[" + c + "]*");
	}
	
	private boolean checkCros(char c) {
		String lr = "" + this.board.charAt(0) + this.board.charAt(4) + this.board.charAt(8);
		String rl = "" + this.board.charAt(2) + this.board.charAt(4) + this.board.charAt(6);
		return lr.matches("[" + c + "]*") || rl.matches("[" + c + "]*");
	}
	
	public boolean isWinner(char c) {
		return checkRows(c) || checkCols(c) || checkCros(c);
	}
	
	public boolean hasWinner() {
		return isWinner('X') || isWinner('O');
	}
	
	public boolean isFinished() {
		return hasWinner() || this.board.indexOf(' ') == -1;
	}
	
	public char getLastPlayer() {
		return this.lastPlayer;
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
		}
		
	

}
