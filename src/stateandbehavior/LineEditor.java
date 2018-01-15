package stateandbehavior;

public class LineEditor {
	
	String text;
	int insertionIndex;
	
	public LineEditor() {
		this.text = "";
		this.insertionIndex = 0;
	}
	
	public void left() {
		if (this.insertionIndex != 0) {
			this.insertionIndex -= 1;
		}
	}
	
	public void right() {
		if (this.insertionIndex != this.text.length()) {
			this.insertionIndex += 1;
		}
	}
	
	public void insertString(String s) {
		this.text = this.text.substring(0, this.insertionIndex) + s + this.text.substring(this.insertionIndex);
		this.insertionIndex += s.length();
	}
	
	public void deleteLeft() {
		if(this.insertionIndex != 0) {
			this.text = this.text.substring(0,this.insertionIndex-1) + this.text.substring(this.insertionIndex);
			this.insertionIndex -= 1;	
		}
	}
	
	public void deleteRight() {
		if(this.insertionIndex != this.text.length()) {
			this.text = this.text.substring(0,this.insertionIndex) + this.text.substring(this.insertionIndex+1);
		}
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
		this.insertionIndex += text.length();
	}
	
	public int getInsertionIndex() {
		return this.insertionIndex;
	}
	
	public void setInsertionIndex(int i) {
		this.insertionIndex = i;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.text.substring(0,this.insertionIndex) + "|" + this.text.substring(this.insertionIndex);
	}
	
	public static void main(String[] args) {
		LineEditor line = new LineEditor();
	
	}

}
