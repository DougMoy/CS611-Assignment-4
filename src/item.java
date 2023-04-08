public abstract class item {
    protected String name;
    protected int level;
    protected String [] itemDescription;
    protected String[] itemLabels;
    protected int price;

    public item(String name, int level, int price){
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
        printArrays.printArray(inputArray,color, i);
    }

    public abstract void useItem(hero currentHero);

}
