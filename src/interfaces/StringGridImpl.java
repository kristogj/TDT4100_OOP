package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringGridImpl implements StringGrid{
	
	private List<ArrayList<String>> grid;
	
	public StringGridImpl(int rows, int columnCount) {
		//init grid
		this.grid = new ArrayList<ArrayList<String>>();
		
		for (int row = 0 ; row < rows ; row++) {
			//make a new row
			ArrayList<String> ar = new ArrayList<String>();
			for(int column = 0 ; column < columnCount ; column++) {
				//add columns to row
				ar.add("1");
			}
			//add row to grid
			grid.add(ar);
		}
	}
	
	@Override
	public String toString() {
		return this.grid.toString();
	}
	
	@Override
	public int getRowCount() {
		return this.grid.size();
	}

	@Override
	public int getColumnCount() {
		return this.grid.get(0).size();
	}

	@Override
	public String getElement(int row, int column) {
		return this.grid.get(row).get(column);
	}

	@Override
	public void setElement(int row, int column, String element) {
		this.grid.get(row).set(column, element);
		
	}
	
	public static void main(String[] args) {
		StringGridImpl s = new StringGridImpl(3,3);
		System.out.println(s);
	}

	@Override
	public Iterator<String> iterator() {
		return new StringGridIterator(this,true);
	}

}
