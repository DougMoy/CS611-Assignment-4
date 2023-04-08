import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;


public class MarketTile extends Tile{
    public ArrayList<item> itemsAvail;
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

    String[] txtFilesItems = {"src/Armory.txt", "src/FireSpells.txt", "src/Potions.txt","src/Weaponry.txt", "src/LightningSpells.txt", "src/IceSpells.txt" };

    //constructor initalizes random items for each market tile
    public MarketTile(int index){
        super(index);
        this.marker = "M";
        Random random = new Random();
        String [] itemArray;
        itemsAvail = new ArrayList<item>();

        for(int i = 0; i<6; i++) {

            itemArray = generateRandom.generateRandom((readInFile.readInText(txtFilesItems[i])), readInFile.countRows(txtFilesItems[i]));

            if (i == 0){


                itemsAvail.add( new armor(itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]), Integer.parseInt(itemArray[3])));
            }else if(i==1){


                itemsAvail.add(new fireSpell (itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]),Integer.parseInt(itemArray[3]),Integer.parseInt(itemArray[4])));}
            else if (i==2) {

                itemsAvail.add( new potion (itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]),Integer.parseInt(itemArray[3]), itemArray[4] ));
            }
            else if (i==3) {

                itemsAvail.add(new weapon (itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]), Integer.parseInt(itemArray[3]), Integer.parseInt(itemArray[4])) );
            }
            else if (i==4) {

                itemsAvail.add( new lightningSpell (itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]),Integer.parseInt(itemArray[3]),Integer.parseInt(itemArray[4])));
            }
            else if (i==5){


                itemsAvail.add( new iceSpell(itemArray[0], Integer.parseInt(itemArray[2]), Integer.parseInt(itemArray[1]),Integer.parseInt(itemArray[3]),Integer.parseInt(itemArray[4])));

            }
        }
    }
    //prints contents of market
    public void printContents (){


        System.out.println("Here is what I have:");
        System.out.println("KEY: " + ANSI_GREEN + "Armor " + ANSI_RED + "FireSpells " + ANSI_PURPLE + "Potions " +ANSI_CYAN + "Weapons " + ANSI_YELLOW + "LightningSpells " + ANSI_BLUE + "IceSpells " + ANSI_WHITE + "Items the heroes have sold me" +ANSI_RESET   );
        for (int i = 0; i < 6; i++){
            String [][] returnArray = new String[][]{readInFile.readInHeader(txtFilesItems[i]),itemsAvail.get(i).getItemDescription()};
            printArrays.printArray(returnArray,colors[i],i);
        }
        for(int j = 6; j < itemsAvail.size(); j++){
           itemsAvail.get(j).labeledItem(j, Colors.ANSI_WHITE);
           System.out.println(ANSI_RESET);

        }
    }
    //returns arraylist of items in market
    public ArrayList<item> getContents(){
        return this.itemsAvail;
    }



}
