import java.util.Scanner;
import java.util.ArrayList;
/*
 * Input.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A class containing terminal input/output utilities.
 * Responsible for prompting the player for decisions.
 */
public class Input {

    static Scanner ogInput = new Scanner(System.in);
    //select hero function

    public static int selectHero(Hero[] heroes){
        for (int i = 0; i <heroes.length; i++){
            System.out.println(Colors.heroColors[i]);
            System.out.println("[" + i + "]" + " " + heroes[i].getName());

        }
        System.out.println(Colors.ANSI_RESET);
        int returnInt = getInt();
        while (returnInt >= heroes.length || returnInt < -1){
            System.out.println("Please enter a valid input");
            returnInt = getInt();
        }
        return returnInt;
    }
    //general getLetter function used to get letter inputs
    public static String getLetter(){
        String letter;
        letter = ogInput.nextLine();
        return letter;
    }
    //more specific userInput letter that is used for main menu controls
    public static String userInputLetter(){
        System.out.println("Controls:");
        System.out.println("W/w: move up");
        System.out.println("A/a: move right");
        System.out.println("S/s: move down");
        System.out.println("D/d: move right");
        System.out.println("I/i: show information");
        System.out.println("M/m: enter market (when on market tile)");
        System.out.println("Q/q: to quit");

        String letter;
        letter = ogInput.nextLine();
        while (!letter.equals("W") &&!letter.equals("w")  && !letter.equals("A") &&!letter.equals("a") && !letter.equals("S") &&!letter.equals("s") && !letter.equals("d") &&!letter.equals("D")
        && !letter.equals("Q") &&!letter.equals("q") && !letter.equals("I") &&!letter.equals("i") && !letter.equals("M") &&!letter.equals("m")){
            System.out.println("Sorry please enter a valid input");
            letter = getLetter();

        }
        return letter;
    }
    //general get int function, makes sure output is an int
    public static int getInt(){
        String stringInt;

        int returnInt = -1;

        stringInt = ogInput.nextLine();

        try {

            returnInt = Integer.parseInt(stringInt);

        }

        catch (NumberFormatException a) {

            System.out.println("Invalid Input, Please Try Again!");
            returnInt = getInt();
        }





        return returnInt;



    }

    public static int pickSomething(String[][] inputArray){
        for(int i = 0; i < inputArray.length; i++){
            System.out.println("[" + i + "]" + inputArray[0]);
        }
        int returnInt = getInt();
        if (returnInt < 0 || returnInt >= inputArray.length){
            System.out.println("Invalid Input, Please Try Again");
            returnInt = getInt();
        }
        return returnInt;
    }
   public static Hero getHero() {
       int count = 0;
       int count1;
       int count2;
       int count3;
       String[] heroArray;
       Hero returnHero;
       System.out.println("Which hero would you like to pick?");
       System.out.println("Here are the paladins:");
       PrintArrays.printArray(ReadInFile.readInText("rsc/paladins.txt"), Colors.ANSI_GREEN, count);
       count1 = (int) ReadInFile.countRows("rsc/paladins.txt") + count - 1;
       System.out.println("Here are the warriors:");
       PrintArrays.printArray(ReadInFile.readInText("rsc/warriors.txt"), Colors.ANSI_RED, count1);
       count2 = (int) ReadInFile.countRows("rsc/warriors.txt") + count1 - 1;
       System.out.println("Here are the sorcerers:");
       count3 = (int) ReadInFile.countRows("rsc/sorcerers.txt");
       PrintArrays.printArray(ReadInFile.readInText("rsc/sorcerers.txt"),Colors.ANSI_BLUE, count2);
       System.out.println("Enter a number to select the corresponding hero:");
       int index = getInt();
       while (index <0 || index > count2 + count3 -2){
           System.out.println("Please enter a valid input ");
           index = getInt();
       }
       ArrayList<Item> emptyInv = new ArrayList<Item>();
       if (index < count1) {
           heroArray = (ReadInFile.readInText("rsc/paladins.txt"))[index + 1];

           returnHero = new Paladin(heroArray[0], 1, Integer.parseInt(heroArray[6]) , 100, Integer.parseInt( heroArray[1]), Integer.parseInt(heroArray[2]), Integer.parseInt(heroArray[4]), Integer.parseInt(heroArray[3]), 0, emptyInv);
       } else if (index >= count1 && index < count2) {
           heroArray = (ReadInFile.readInText("rsc/warriors.txt"))[index - count1 + 1];

           returnHero = new Warrior(heroArray[0], 1, Integer.parseInt(heroArray[6]) , 100, Integer.parseInt( heroArray[1]), Integer.parseInt(heroArray[2]), Integer.parseInt(heroArray[4]), Integer.parseInt(heroArray[3]), 0, emptyInv);
       } else {
           heroArray = (ReadInFile.readInText("rsc/sorcerers.txt"))[index - count2 + 1];

           returnHero = new Sorcerer(heroArray[0], 1, Integer.parseInt(heroArray[6]) , 100, Integer.parseInt( heroArray[1]), Integer.parseInt(heroArray[2]), Integer.parseInt(heroArray[4]), Integer.parseInt(heroArray[3]), 0, emptyInv);
       }

       return returnHero;



   }

   public static Hero[] getHeroes(){
        System.out.println("How many heroes do you want to play on your team? Maximum: 4");
        int numberHeroes = getInt();
        while(numberHeroes > 4){
            System.out.println("Please enter a valid input that is less than 4");
            numberHeroes = getInt();
        }
        Hero[] heroes = new Hero[numberHeroes];
        int count = 0;
        for (int i = 0; i <numberHeroes; i++){
            heroes[i] = getHero();

       }
return heroes;
   }




}
