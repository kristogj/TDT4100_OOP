package eksamen.kont2017;

import java.util.ArrayList;
import java.util.Collection;

public class Table implements KitchenListener{

    private final Menu menu;
    private Collection<MenuItem> menuItems;
    private Kitchen kitchen;

    public Table(Menu menu) {
        this.menuItems = new ArrayList<MenuItem>();
        this.menu = menu;
    }

    public void addMenuItem(MenuItem item){
        menuItems.add(item);
    }
    
    public double getPrice() throws IllegalStateException {
    	try {
    		return menuItems.stream().map(item -> menu.getPrice(item)).reduce((a,b) -> a + b).get();
		} catch (Exception e) {
			throw new IllegalStateException();
		}
    }
    
    public void setKitchen(Kitchen kitchen) {
        if (this.kitchen != null) {
            this.kitchen.removeListener(this);
        }
        this.kitchen = kitchen;
        if (this.kitchen != null) {
            this.kitchen.addListener(this);
        }      
    }

	@Override
	public void courseReady(Table table, Course course) {
		//get foood
		
	}
}
