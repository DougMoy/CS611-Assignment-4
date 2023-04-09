import java.util.Random;
/*
 * GenerateRandom.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A class containing random number utilities.
 */
public class GenerateRandom {
    //picks random row from 2d string array
    public static String [] generateRandom (String [][] inputArray, int Count ){
        Random random = new Random();
        int index = random.nextInt(Count-1);
        return inputArray[index + 1];
    }
    public static String[] generateRandomWnoHeader(String [][] inputArray, int Count ){
        Random random = new Random();
        int index = random.nextInt(Count);
        return inputArray[index];
    }


}
