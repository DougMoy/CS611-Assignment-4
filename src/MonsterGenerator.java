import java.lang.reflect.Array;
import java.util.ArrayList;
public class MonsterGenerator {
    public static int numRowsDragon;
    public static int numRowsExo;
    public static int numRowsSpirit;

    public static String [][] dragonsArray;
    public static String [][] exoArray;
    public static String [][] spiritArray;

    public static int numRows;

    public static String[][]monsterArray;

    //generates monsters from the 3 files of monsters we are given
    public MonsterGenerator(){
        numRowsDragon = ReadInFile.countRows("rsc/Dragons.txt") -1;
        numRowsExo = ReadInFile.countRows("rsc/Exoskeletons.txt")-1;
        numRowsSpirit = ReadInFile.countRows("rsc/spirits.txt")-1;
        dragonsArray = ReadInFile.readInText("rsc/Dragons.txt");
        exoArray = ReadInFile.readInText("rsc/Exoskeletons.txt");
        spiritArray = ReadInFile.readInText("rsc/spirits.txt");
        numRows = numRowsDragon + numRowsExo + numRowsSpirit;
       monsterArray = new String [numRows][5];

        for(int i = 0; i < numRows; i++){

            if (i < numRowsDragon){
                monsterArray[i] = dragonsArray[i+1];

            }
            else if (i >= (numRowsDragon) && i <numRowsSpirit + numRowsDragon + 1){


                monsterArray[i] = exoArray[i -(numRowsDragon) +1 ];

            }
            else {
                monsterArray[i] = spiritArray[i - (numRowsDragon + numRowsSpirit) ];

            }
        }

    }

    public static void printMonsters(){
        //testing function
        PrintArrays.printArray(monsterArray, "\u001B[37m", 0);
    }
    //filters monsters based on level
    public static String [][] filterMonstersLevel(int level){
        int count =0;
        for (int i = 0; i < monsterArray.length; i++){
            if (Integer.parseInt(monsterArray[i][1]) == level || (level >=10 &&Integer.parseInt(monsterArray[i][1]) >=10 )){
                count = count + 1;
            }
        }
        String [][]returnMonsters = new String [count][5];
        int monsterCounter = 0;
        for (int i = 0; i < monsterArray.length; i++){
            if (Integer.parseInt(monsterArray[i][1]) == level || (level >=10 &&Integer.parseInt(monsterArray[i][1]) >=10 )){
                returnMonsters[monsterCounter] = monsterArray[i];
                monsterCounter = monsterCounter + 1;
            }
        }
        return returnMonsters;
    }

    //takes String [][] and actually makes an arrayList of monsters
    public static ArrayList<Monster> generateMonster (String [][] inputArray){
        ArrayList<Monster> returnArray =  new ArrayList<Monster>();
        for (int i = 0; i < inputArray.length; i++ ){
            returnArray.add( new Monster(inputArray[i][0], Integer.valueOf(inputArray[i][1]), Integer.valueOf(inputArray[i][2]), Integer.valueOf(inputArray[i][3]),Integer.valueOf(inputArray[i][4])));
        }
        return returnArray;
    }




}
