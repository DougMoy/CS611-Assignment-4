import java.util.ArrayList;

public class Inventory {
    protected ArrayList<Item> inventory;
    public Inventory(){
        inventory = new ArrayList<Item>();
    }

    public Item get(int i ){
        Item returnItem = inventory.get(i);
        return returnItem;
    }
    public void remove(Item i){
       inventory.remove(i);

    }
    public void add(Item i){
        inventory.add(i);
    }

    public void remove(int i){
        inventory.remove(i);
    }
    public int getSize(){
        int returnSize = inventory.size();
        return returnSize;
    }
    public ArrayList<Item> getItems(){
        return this.inventory;
    }

}
