package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String>{
	
	private StringGrid stringGrid;
	// True ? iterate horizontally : iterate vertically;
	private boolean rowMajor;
	
	private int row,column;
	
	public StringGridIterator(StringGrid stringGrid , boolean rowMajor) {
		this.stringGrid = stringGrid;
		this.rowMajor = rowMajor;
		this.row = 0;
		this.column = 0;
	}
	
	@Override
	public boolean hasNext() {
		//Stops down in the right corner anyways
		return ! (row == stringGrid.getRowCount()  || column == stringGrid.getColumnCount());
	}

	@Override
	public String next() {
		String str = stringGrid.getElement(row, column);
		if(rowMajor) {
			row = (column == stringGrid.getColumnCount() - 1) ? row + 1: row;
			column = (column == stringGrid.getColumnCount() - 1) ? 0 : column + 1;
		}
		else {
			column = (row == stringGrid.getRowCount() - 1) ? column + 1: column;
			row = (row == stringGrid.getRowCount() - 1) ? 0 : row + 1;
		}
		return str;
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	
	public static void main(String[] args) {
		//Will be rowMajor
		StringGrid s = new StringGridImpl(2,2);
		s.setElement(0, 1, "2");
		s.setElement(1, 0, "3");
		s.setElement(1, 1, "4");
		System.out.println(s);
		for(String t : s) {
			System.out.println(t);
		}
	}
	

}
