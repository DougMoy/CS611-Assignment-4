/*
 * Item.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * An abstract class representing usable Items.
 * Items are various types of items stored in the inventory.
 * Subtypes include potions, spells, and equipment.
 */
public abstract class Item {
    protected String name;
    protected int level;
    protected String [] itemDescription;
    protected String[] itemLabels;
    protected int price;

    public Item(String name, int level, int price){
        this.name = name;
        this.level = level;
        this.price = price;
    }

    public String[] getItemDescription(){
         return this.itemDescription;
    }

    public int getLevel(){
        return this.level;
    }

    public int getPrice(){
        return this.price;
    }

    public void labeledItem (int i, String color){
        String [][] inputArray = new String[][]{this.itemLabels,this.itemDescription};
        PrintArrays.printArray(inputArray,color, i);
    }

    public abstract void useItem(Hero currentHero);

}
