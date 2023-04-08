import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class readInFile {

    public static int countRows(String fileName) {

        Path path = Paths.get(fileName);

        long lines = 0;
        try {

            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return (int)lines;

    }

    public static String[] readInHeader(String fileName){
        BufferedReader reader;

        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int cols = line.split("/",-1).length;
            long rows = countRows(fileName);
            int rowsInt = (int)rows;
            String []returnArray;
            returnArray = line.split("/",-1);
            return returnArray;

        }
        catch(IOException e){
            e.printStackTrace();
        }
        String [] val= new String []{"FAILURE"};
        return val;
    }

    public static String [][]readInText(String fileName){
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int cols = line.split("/",-1).length;
            long rows = countRows(fileName);
            int rowsInt = (int)rows;
            String [][] returnArray = new String [rowsInt][cols];
            returnArray[0] = line.split("/",-1);
            line = reader.readLine();
            int count = 0;
            while (line != null) {
                count = count + 1;
                if (count > 49){
                    reader.close();
                    return returnArray;
                }
                returnArray[count] = line.split("\\s+",-1);
                line = reader.readLine();
            }
            return returnArray;


        } catch (IOException e) {
            System.out.println("FAILUREE");
            String [][] returnArray = new String [1][1];
            e.printStackTrace();
        }
        String [][] failure = {{"Failure"}};
        return failure;
    }

}
