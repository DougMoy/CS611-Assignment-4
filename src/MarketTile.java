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

    protected String [] itemArray;
    protected String[] colors = new String[]{Colors.ANSI_GREEN,Colors.ANSI_RED,Colors.ANSI_PURPLE,Colors.ANSI_CYAN,Colors.ANSI_YELLOW,Colors.ANSI_BLUE};

    public String[] txtFilesItems = {"rsc/Armory.txt", "rsc/FireSpells.txt", "rsc/Potions.txt","rsc/Weaponry.txt", "rsc/LightningSpells.txt", "rsc/IceSpells.txt" };

    //constructor initalizes random items for each market tile
    public MarketTile(int index){
        super(index);
        this.marker = "M";
        Random random = new Random();

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
        System.out.println("KEY: " + Colors.ANSI_GREEN + "Armor " + Colors.ANSI_RED + "FireSpells " + Colors.ANSI_PURPLE + "Potions " +Colors.ANSI_CYAN + "Weapons " + Colors.ANSI_YELLOW + "LightningSpells " + Colors.ANSI_BLUE + "IceSpells " + Colors.ANSI_WHITE + "Items the heroes have sold me" +Colors.ANSI_RESET   );
        for (int i = 0; i < 6; i++){
            String [][] returnArray = new String[][]{ReadInFile.readInHeader(txtFilesItems[i]),itemsAvail.get(i).getItemDescription()};
            PrintArrays.printArray(returnArray,colors[i],i);
        }
        for(int j = 6; j < itemsAvail.size(); j++){
           itemsAvail.get(j).labeledItem(j, Colors.ANSI_WHITE);
           System.out.println(Colors.ANSI_RESET);

        }
    }
    //returns arraylist of items in market
    public ArrayList<Item> getContents(){
        return this.itemsAvail;
    }



}
