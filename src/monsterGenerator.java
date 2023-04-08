import java.lang.reflect.Array;
import java.util.ArrayList;
public class monsterGenerator {
    public static int numRowsDragon;
    public static int numRowsExo;
    public static int numRowsSpirit;

    public static String [][] dragonsArray;
    public static String [][] exoArray;
    public static String [][] spiritArray;

    public static int numRows;

    public static String[][]monsterArray;

    //generates monsters from the 3 files of monsters we are given
    public monsterGenerator(){
        numRowsDragon =readInFile.countRows("src/Dragons.txt") -1;
        numRowsExo = readInFile.countRows("src/Exoskeletons.txt")-1;
        numRowsSpirit = readInFile.countRows("src/spirits.txt")-1;
        dragonsArray = readInFile.readInText("src/Dragons.txt");
        exoArray = readInFile.readInText("src/Exoskeletons.txt");
        spiritArray = readInFile.readInText("src/spirits.txt");
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
        printArrays.printArray(monsterArray, "\u001B[37m", 0);
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
    public static ArrayList<monster> generateMonster (String [][] inputArray){
        ArrayList<monster> returnArray =  new ArrayList<monster>();
        for (int i = 0; i < inputArray.length; i++ ){
            returnArray.add( new monster(inputArray[i][0], Integer.valueOf(inputArray[i][1]), Integer.valueOf(inputArray[i][2]), Integer.valueOf(inputArray[i][3]),Integer.valueOf(inputArray[i][4])));
        }
        return returnArray;
    }




}
