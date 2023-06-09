import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LegendsOfValorBoard extends Board {
    public int heroIndex;
    public int[] playerXs, playerYs;
    public List<Integer> monsterXs, monsterYs;
    public LegendsOfValorBoard (int rows, int cols){
        super (rows, cols);
        this.heroIndex = 0;
        playerXs = new int[]{1, 4, 7};
        playerYs = new int[]{rows-1, rows-1, rows-1};
        playerX = rows-1;
        playerY = 1;
        monsterXs = new ArrayList();
        monsterYs = new ArrayList();
        int count = 0;

        for (int i = 0; i< rows; i++){

            for (int j = 0; j <cols; j++){
                if( i == 0){
                    this.actualBoard[i][j] = new MonsterNexus(count);

                }
                else if (i == rows-1){
                    this.actualBoard[i][j] = new HeroNexus(count);
                }
                else{
                    double prob = Math.random();
                    if (prob<=.2){
                        this.actualBoard[i][j] = new Bush(count);
                    }
                    else if (prob<=.4){
                        this.actualBoard[i][j] = new Cave(count);
                    }
                    else if (prob <=.6){
                        this.actualBoard[i][j] = new Koulou(count);

                    }
                    else {
                        this.actualBoard[i][j] = new CommonSpace(count);
                    }
                }
            }


        }
        for(int i = 0; i < rows; i++){
            this.actualBoard[i][2]= new InaccessibleTile(count);
            this.actualBoard[i][5]= new InaccessibleTile(count);
        }

    }

    //ad hoc method to use parent methods.
    public void setHero(int i) {
        assert i > 0 && i < 3;
        playerXs[heroIndex] = playerY;
        playerYs[heroIndex] = playerX;
        heroIndex = i;
        playerY = playerXs[i];
        playerX = playerYs[i];
    }

    public boolean checkHeroWin(){
        //check for win function for heroes, allows for expandability because not hard coding where monster nexi are
        if(this.actualBoard[playerX][playerY] instanceof MonsterNexus) return true;
        for (int i = 0; i < playerXs.length; i++){
            if(this.actualBoard[playerYs[i]][playerXs[i]] instanceof MonsterNexus){
                return true;
            }
        }
        return false;
    }


    public void teleport(int heroIndex){
        int validInput1;
        int validInput2;
        System.out.println("Which hero would you like to TP to?");
        if (heroIndex == 1){
            validInput1 = 0;
            validInput2 = 2;

        }
        else if (heroIndex == 2){
            validInput1 = 0;
            validInput2 = 1;
        }
        else{
            validInput1 = 1;
            validInput2 = 2;

        }
        System.out.println("[" + validInput1 + "]");
        System.out.println("[" + validInput2 + "]");
        int userInput = Input.getInt();
        if(userInput != validInput1 && userInput != validInput2){
            System.out.println("Please try again");
            userInput = Input.getInt();
        }

        ArrayList <String> validMoves = getValidLetters(userInput);
        if(validMoves.size() ==0 ){
            System.out.println("No valid spaces to teleport to");
            return;
        }
        System.out.println("Select A to teleport left to a player, S to teleport below a player, D to teleport right to a player");

        for(int i = 0; i< validMoves.size(); i++){
            System.out.println("[" + validMoves.get(i) + "]");
        }
        String userLetter = Input.getLetter();

        while(!validMoves.contains(userLetter)){
            System.out.println("Sorry please enter a valid move");
            userLetter = Input.getLetter();
        }

        if(userLetter.equals("W")){

            playerY = playerXs[userInput];
            playerX = playerYs[userInput] - 1;

        }
        else if(userLetter.equals("A")){
            playerY = playerXs[userInput] - 1;
            playerX = playerYs[userInput];
        }
        else if(userLetter.equals("S")){
            playerY = playerXs[userInput];
            playerX = playerYs[userInput] + 1;
        }
        else if(userLetter.equals("D")){
            playerY = playerXs[userInput] + 1;
            playerX = playerYs[userInput] ;
        }




    }

    public ArrayList<String> getValidLetters(int heroIndex){
        ArrayList <String> returnArray = new ArrayList<String>();

        if (testValidMoveA(heroIndex) == true){
            returnArray.add("A");
        }
        if (testValidMoveS(heroIndex) == true){
            returnArray.add("S");
        }
        if (testValidMoveD(heroIndex) == true){
            returnArray.add("D");
        }
        return returnArray;
    }

    public boolean testValidMoveW(int heroIndex){

        if(playerYs[heroIndex] -1 <0){
            return false;
        }

        for (int i = 0; i < monsterXs.size(); i++) {
            if ((playerYs[heroIndex]) - 1 == monsterYs.get(i) && playerXs[heroIndex] == monsterXs.get(i)){
                return false;
            }
        }

        for (int i = 0; i < playerXs.length; i++) {
            if (i == heroIndex) continue;
            if (playerYs[heroIndex] - 1 == playerYs[i] && playerXs[heroIndex] == playerXs[i])
                return false;
        }

        if(actualBoard[playerYs[heroIndex]-1][playerXs[heroIndex]].isWalkable == false ){
            return false;
        }



        return true;

    }

    public boolean testValidMoveA(int heroIndex){
        if(playerXs[heroIndex] -1 <0){
            return false;
        }

        for (int i = 0; i < monsterXs.size(); i++) {
            if ((playerYs[heroIndex])  == monsterYs.get(i) && playerXs[heroIndex] -1 == monsterXs.get(i)){
                return false;
            }
        }

        for (int i = 0; i < playerXs.length; i++) {
            if (i == heroIndex) continue;
            if (playerYs[heroIndex]  == playerYs[i] && playerXs[heroIndex] -1 == playerXs[i])
                return false;
        }

        if(actualBoard[playerYs[heroIndex]][playerXs[heroIndex]-1].isWalkable == false ){
            return false;
        }


        return true;

    }

    public boolean testValidMoveS(int heroIndex){
        if(playerYs[heroIndex] +1 >= rows){
            return false;
        }

        for (int i = 0; i < monsterXs.size(); i++) {
            if ((playerYs[heroIndex]) + 1  == monsterYs.get(i) && playerXs[heroIndex]  == monsterXs.get(i)){
                return false;
            }
        }

        for (int i = 0; i < playerXs.length; i++) {
            if (i == heroIndex) continue;
            if (playerYs[heroIndex] +1  == playerYs[i] && playerXs[heroIndex]  == playerXs[i])
                return false;
        }

        if(actualBoard[playerYs[heroIndex]+1][playerXs[heroIndex]].isWalkable == false ){
            return false;
        }


        return true;

    }

    public boolean testValidMoveD(int heroIndex){

        if(playerXs[heroIndex] +1 >= rows){
            return false;
        }

        for (int i = 0; i < monsterXs.size(); i++) {
            if ((playerYs[heroIndex])   == monsterYs.get(i) && playerXs[heroIndex] +1 == monsterXs.get(i)){
                return false;
            }
        }

        for (int i = 0; i < playerXs.length; i++) {
            if (i == heroIndex) continue;
            if (playerYs[heroIndex]   == playerYs[i] && playerXs[heroIndex] +1  == playerXs[i])
                return false;
        }

        if(actualBoard[playerYs[heroIndex]][playerXs[heroIndex]+1].isWalkable == false ){
            return false;
        }


        return true;

    }

    public boolean checkMonsterWin(){
        for (int i = 0; i < monsterXs.size(); i++){
            if (this.actualBoard[monsterYs.get(i)][monsterXs.get(i)] instanceof HeroNexus){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isValidMove(String direction) {
        if (super.isValidMove(direction)){
            //test collision with monsters and players
            for (int i = 0; i < monsterXs.size(); i++){
                switch(direction){
                    case "w": {if (playerX - 1 == monsterYs.get(i) && playerY == monsterXs.get(i)) {
                        return false;
                        }
                        break;
                    }
                    case "a": {if (playerX == monsterYs.get(i) && playerY - 1 == monsterXs.get(i)) {
                        return false;
                        }
                        break;
                    }
                    case "s": {if (playerX + 1 == monsterYs.get(i) && playerY == monsterXs.get(i)) {
                        return false;
                        }
                        break;
                    }
                    case "d": {if (playerX == monsterYs.get(i) && playerY + 1 == monsterXs.get(i)) {
                        return false;
                        }
                        break;
                    }
                }
            }
            for (int i = 0; i < playerXs.length; i++){
                if (i == heroIndex) continue;
                switch(direction){
                    case "w": {if (playerX - 1 == playerYs[i] && playerY == playerXs[i])
                        return false;
                    }
                    break;
                    case "a" : {if (playerX == playerYs[i] && playerY - 1 == playerXs[i])
                        return false;
                    }
                    break;
                    case "s" : {if (playerX + 1 == playerYs[i] && playerY == playerXs[i])
                        return false;
                    }
                    break;
                    case "d" : {if (playerX == playerYs[i] && playerY + 1 == playerXs[i])
                        return false;
                    }
                    break;
                }
            }
            return true;
        }
        return false;
    }

    //has neither hero nor monster
    public boolean isEmpty(int row, int col){
        if (row < 0 || col < 0 || row >= rows || col >= cols) return false;
        for (int i = 0; i < playerXs.length; i++){
            if (playerYs[i] == row && playerXs[i] == col) return false;
        }
        for (int i = 0; i < monsterXs.size(); i++){
            if (monsterXs.get(i) == row && monsterYs.get(i) == col) return false;
        }
        return true;
    }

    public boolean recall(int i) {
        if (isEmpty(1 + 3*i,rows-1)) {
            playerY = 1 + 3*i;
            playerX = rows-1;
            return true;
        }
        else if(isEmpty(0 + 3*i,rows-1)){
            playerY = 0 + 3*i;
            playerX = rows-1;
            return true;
        }
        return false;
    }



    private int heroOn(int row, int col){
        for (int i = 0; i < playerXs.length; i++){
            if (playerXs[i] == col && playerYs[i] == row) return i;
        }
        return -1;
    }

    private int monsterOn(int row, int col){
        for (int i = 0; i < monsterXs.size(); i++){
            if (monsterXs.get(i) == col && monsterYs.get(i) == row) return i;
        }
        return -1;
    }

    @Override
    public void printBoard() {
        //prints the board
        System.out.print("  +");

        for (int j = 0; j < cols; j++) {

            System.out.print("---+");

        }

        System.out.println();

        for (int i = 0; i < rows; i++) {

            System.out.print(i + " |");

            for (int j = 0; j < cols; j++) {
                if (heroOn(i,j) != -1){
                    System.out.print("*");
                    System.out.print(Colors.heroBGColors[heroOn(i,j)]);
                    System.out.print(actualBoard[i][j].getMarker());
                    System.out.print(Colors.ANSI_RESET);
                    System.out.print("*|");
                }
                else if (monsterOn(i,j) != -1){
                    System.out.print("-");
                    System.out.print(Colors.ANSI_BG_BLACK + Colors.ANSI_WHITE);
                    System.out.print(actualBoard[i][j].getMarker());
                    System.out.print(Colors.ANSI_RESET);
                    System.out.print("-|");
                }
                else if(actualBoard[i][j].getMarker().equals("M")){
                    System.out.print(" ");
                    System.out.print(Colors.ANSI_RED);
                    System.out.print(actualBoard[i][j].getMarker());

                    System.out.print(Colors.ANSI_RESET);
                    System.out.print(" |");
                }
                else if(actualBoard[i][j].getMarker().equals("H")){
                    System.out.print(" ");
                    System.out.print(Colors.ANSI_BLUE);
                    System.out.print(actualBoard[i][j].getMarker());

                    System.out.print(Colors.ANSI_RESET);
                    System.out.print(" |");
                }
                else if (actualBoard[i][j].getMarker().equals("K")){
                    System.out.print(" ");
                    System.out.print(Colors.ANSI_GREEN);
                    System.out.print(actualBoard[i][j].getMarker());

                    System.out.print(Colors.ANSI_RESET);
                    System.out.print(" |");
                }
                else if (actualBoard[i][j].getMarker().equals("B")){
                    System.out.print(" ");
                    System.out.print(Colors.ANSI_PURPLE);
                    System.out.print(actualBoard[i][j].getMarker());

                    System.out.print(Colors.ANSI_RESET);
                    System.out.print(" |");
                } else if (actualBoard[i][j].getMarker().equals("C")){
                    System.out.print(" ");
                    System.out.print(Colors.ANSI_YELLOW);
                    System.out.print(actualBoard[i][j].getMarker());

                    System.out.print(Colors.ANSI_RESET);
                    System.out.print(" |");
                }
                else if (actualBoard[i][j].getMarker().equals("E")){
                    System.out.print(" ");
                    System.out.print(Colors.ANSI_RED);
                    System.out.print(actualBoard[i][j].getMarker());

                    System.out.print(Colors.ANSI_RESET);
                    System.out.print(" |");
                }


                else {
                    System.out.print(" " + actualBoard[i][j].getMarker() + " |");
                }
            }

            System.out.println("");

            System.out.print("  +");

            for (int j = 0; j < cols; j++) {

                System.out.print("---+");

            }
            System.out.println();
        }
        System.out.print("  ");
        for (int j = 0; j < cols; j++) {

            if (j == 0){
                System.out.print("  " + j);
            }
            else{
                System.out.print("   " + j);
            }

        }
        System.out.println();
    }
}
