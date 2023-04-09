import java.util.ArrayList;

public class HeroNexus extends MarketTile{

    public HeroNexus (int index){
        super(index);
        this.itemsAvail = new ArrayList<Item>();
        String[][] tempArray;

       for (int i = 0; i < 6; i++){
           tempArray = ReadInFile.readInText(txtFilesItems[i]);
           for(int j = 1; j < tempArray.length; j ++){
               if(i ==0){
                   itemsAvail.add( new Armor(tempArray[j][0], Integer.parseInt(tempArray[j][2]), Integer.parseInt(tempArray[j][1]), Integer.parseInt(tempArray[j][3])));
               }
               else if (i == 1){
                   itemsAvail.add(new FireSpell(tempArray[j][0], Integer.parseInt(tempArray[j][2]), Integer.parseInt(tempArray[j][1]),Integer.parseInt(tempArray[j][3]),Integer.parseInt(tempArray[j][4])));
               }
               else if(i == 2){
                   itemsAvail.add( new Potion(tempArray[j][0], Integer.parseInt(tempArray[j][2]), Integer.parseInt(tempArray[j][1]),Integer.parseInt(tempArray[j][3]), tempArray[j][4] ));
               }else if (i==3) {

                   itemsAvail.add(new Weapon(tempArray[j][0], Integer.parseInt(tempArray[j][2]), Integer.parseInt(tempArray[j][1]), Integer.parseInt(tempArray[j][3]), Integer.parseInt(tempArray[j][4])) );
               }
               else if (i==4) {

                   itemsAvail.add( new LightningSpell(tempArray[j][0], Integer.parseInt(tempArray[j][2]), Integer.parseInt(tempArray[j][1]),Integer.parseInt(tempArray[j][3]),Integer.parseInt(tempArray[j][4])));
               }
               else if (i==5){


                   itemsAvail.add( new IceSpell(tempArray[j][0], Integer.parseInt(tempArray[j][2]), Integer.parseInt(tempArray[j][1]),Integer.parseInt(tempArray[j][3]),Integer.parseInt(tempArray[j][4])));

               }

               }
           }
       }

       public void printContents(){
        int count = 0;
           System.out.println("Here is what I have:");
           System.out.println("KEY: " + Colors.ANSI_GREEN + "Armor " + Colors.ANSI_RED + "FireSpells " + Colors.ANSI_PURPLE + "Potions " +Colors.ANSI_CYAN + "Weapons " + Colors.ANSI_YELLOW + "LightningSpells " + Colors.ANSI_BLUE + "IceSpells " + Colors.ANSI_WHITE + "Items the heroes have sold me" +Colors.ANSI_RESET   );
           for (int i =0; i < 6; i++){
                String [][] tempItemArray = ReadInFile.readInText(txtFilesItems[i]);
                PrintArrays.printArray(tempItemArray, colors[i], count);
                count = count + tempItemArray.length -1;
           }
       }
    }


