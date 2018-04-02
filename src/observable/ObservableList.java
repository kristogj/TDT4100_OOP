package observable;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ObservableList {
	
	protected List<Object> elements;
	protected Set<ObservableListListener> listeners;
	
	public ObservableList() {
		this.elements = new ArrayList<Object>();
		this.listeners = new HashSet<ObservableListListener>();
	}
	
	public int size() {
		return elements.size();
	}
	
	public Object getElement(int index) {
		return this.elements.get(index);
	}
	
	abstract boolean acceptsElement(Object object);
	
	
	protected void addElement(int position, Object object) {
		if(!acceptsElement(object)) {
			throw new IllegalArgumentException();
		}
		if(position < 0 || position > size()) {
			throw new IndexOutOfBoundsException();
		}
		elements.add(position,object);
	}
	
	protected void addElement(Object object) {
		if(!acceptsElement(object)) {
			throw new IllegalArgumentException();
		}
		elements.add(object);
	}
	
	protected void removeElement(int i) {
		if(i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}	
		elements.remove(i);
	}
	
	public void addObservableListListener(ObservableListListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeObservableListListener(ObservableListListener listener) {
		this.listeners.remove(listener);
	}
}
