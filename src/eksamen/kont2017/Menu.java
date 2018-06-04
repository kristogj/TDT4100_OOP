package eksamen.kont2017;

import java.util.Map;

public class Menu{
    
    //bytter ut til felles map med MenuItem
    private Map<MenuItem,Double> itemPriceMenu;
    
    //Trenger nå kun en getPrice, og en updatePrice
    public double getPrice(MenuItem item){
        if(!itemPriceMenu.containsKey(item)){
            throw new IllegalArgumentException();
        }
        Double price = itemPriceMenu.get(item);
        if(item instanceof Meal && price == 0.0){
            for (Course course : (Meal)item){
                if( ! itemPriceMenu.containsKey(course)){
                    throw new IllegalArgumentException();
                }
                price += itemPriceMenu.get(course);
            }
        }
        return price;
    }
    
    public void updatePrice(MenuItem item, double price){
        itemPriceMenu.put(item,price);
    }
}
