import java.util.Random;
import java.util.ArrayList;
/*
 * MarketTile.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The MarketTile object is a subclass extending Tile.
 * MarketTile allows players on it to buy and sell various items.
 */
public class MarketTile extends Tile{
    public ArrayList<Item> itemsAvail;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    String[] colors = new String[]{ANSI_GREEN,ANSI_RED,ANSI_PURPLE,ANSI_CYAN,ANSI_YELLOW,ANSI_BLUE};

    String[] txtFilesItems = {"rsc/Armory.txt", "rsc/FireSpells.txt", "rsc/Potions.txt","rsc/Weaponry.txt", "rsc/LightningSpells.txt", "rsc/IceSpells.txt" };

    //constructor initalizes random items for each market tile
    public MarketTile(int index){
        super(index);
        this.marker = "M";
        Random random = new Random();
        String [] itemArray;
        itemsAvail = new ArrayList<Item>();

        for(int i = 0; i<6; i++) {

            itemArray = GenerateRandom.generateRandom((ReadInFile.readInText(txtFilesItems[i])), ReadInFile.countRows(txtFilesItems[i]));

            if (i == 0){


                itemsAvail.add( new Armor(itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]), Integer.parseInt(itemArray[3])));
            }else if(i==1){


                itemsAvail.add(new FireSpell(itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]),Integer.parseInt(itemArray[3]),Integer.parseInt(itemArray[4])));}
            else if (i==2) {

                itemsAvail.add( new Potion(itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]),Integer.parseInt(itemArray[3]), itemArray[4] ));
            }
            else if (i==3) {

                itemsAvail.add(new Weapon(itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]), Integer.parseInt(itemArray[3]), Integer.parseInt(itemArray[4])) );
            }
            else if (i==4) {

                itemsAvail.add( new LightningSpell(itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]),Integer.parseInt(itemArray[3]),Integer.parseInt(itemArray[4])));
            }
            else if (i==5){


                itemsAvail.add( new IceSpell(itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]),Integer.parseInt(itemArray[3]),Integer.parseInt(itemArray[4])));

            }
        }
    }
    //prints contents of market
    public void printContents (){


        System.out.println("Here is what I have:");
        System.out.println("KEY: " + ANSI_GREEN + "Armor " + ANSI_RED + "FireSpells " + ANSI_PURPLE + "Potions " +ANSI_CYAN + "Weapons " + ANSI_YELLOW + "LightningSpells " + ANSI_BLUE + "IceSpells " + ANSI_WHITE + "Items the heroes have sold me" +ANSI_RESET   );
        for (int i = 0; i < 6; i++){
            String [][] returnArray = new String[][]{ReadInFile.readInHeader(txtFilesItems[i]),itemsAvail.get(i).getItemDescription()};
            PrintArrays.printArray(returnArray,colors[i],i);
        }
        for(int j = 6; j < itemsAvail.size(); j++){
           itemsAvail.get(j).labeledItem(j, Colors.ANSI_WHITE);
           System.out.println(ANSI_RESET);

        }
    }
    //returns arraylist of items in market
    public ArrayList<Item> getContents(){
        return this.itemsAvail;
    }



}
