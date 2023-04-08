import java.util.Random;

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
