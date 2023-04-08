public class printArrays {
    //prints and formats 2d string arrays

    public static int longestWord(String [][] inputArray){
        int longest = 0;
        for (int i = 0; i < inputArray.length; i++) {


            for (int j = 0; j < inputArray[i].length; j++) {

                if (inputArray[i][j].length() > longest){
                    //System.out.println(inputArray[i][j]);
                    longest = inputArray[i][j].length();
                }
            }
        }
        return longest;
    }

    public static void printArray (String [][] inputArray, String color, int count){

        int longest = longestWord(inputArray) + 3;

        String printFormat = "%-" + longest + "s";
        System.out.println(color);
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println("");
            // Loop through all elements of current row
            for (int j = 0; j < inputArray[i].length; j++) {
                if (j == 0 && i != 0) {
                    if (count < 10){
                    System.out.print("[" + count + "]  ");
                    count = count + 1;}
                    else{
                        System.out.print("[" + count + "] ");
                        count = count +1;
                    }
                }
                if (i == 0 && j == 0){
                    System.out.print("     ");
                }
                System.out.printf(printFormat, ( inputArray[i][j]));
            }
        }
        System.out.println(Colors.ANSI_RESET);

    }
}
