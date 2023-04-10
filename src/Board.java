/*
 * Board.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * This class represents a 2d board that players can move around it.
 * It consists of a grid of Tile objects with a set number of rows and columns.
 * The class is responsible for keeping track of the players location and moving the player.
 */
public abstract class Board {

    protected static int rows;

    protected static int cols;
    protected static int playerX;
    protected static int playerY;


    protected static Tile[][] actualBoard;

    public Board (int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.playerX = 0;
        this.playerY = 0;
        this.actualBoard = new Tile[rows][cols];


    }
    //setting coordinates to where the player is
    public void setX (int x){
        this.playerX = x;

    }
    public void setY (int y){
        this.playerY = y;
    }

    //prints board
    public void printBoard() {

        //prints the board

        System.out.print("  +");

        for (int j = 0; j < cols; j++) {

            System.out.print("---+");

        }

        System.out.println("");

        for (int i = 0; i < rows; i++) {

            System.out.print(i + " |");

            for (int j = 0; j < cols; j++) {
                if (actualBoard[i][j].isThePlayerOn()){
                    System.out.print(" ");
                    System.out.print(Colors.ANSI_CYAN);
                    System.out.print("@");
                    System.out.print(Colors.ANSI_RESET);
                    System.out.print(" |");
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

    }
    //individual functions that move the player in a direction on the board
    public void playW(){
        this.actualBoard[playerX][playerY].playerOff();
        this.setX(playerX -1);
        this.actualBoard[playerX][playerY].playerOn();
    }

    public void playA(){
        this.actualBoard[playerX][playerY].playerOff();
        this.setY(playerY-1);
        this.actualBoard[playerX][playerY].playerOn();
    }

    public void playS(){
        this.actualBoard[playerX][playerY].playerOff();
        this.setX(playerX+1);
        this.actualBoard[playerX][playerY].playerOn();
    }




    public void playD(){
        this.actualBoard[playerX][playerY].playerOff();
        this.setY(playerY+1);
        this.actualBoard[playerX][playerY].playerOn();
    }

    //combines the previous four functions to simulate user movement on the board, uses functions below to test first that move is legal.
    public void playMoveDirection(String direction){
        if (direction.equals("W")|| direction.equals("w")){
            this.playW();
        }
        else if (direction.equals("A")|| direction.equals("a")){
            this.playA();
        }
        else if (direction.equals("S")|| direction.equals("s")){
            this.playS();
        }
        else if (direction.equals("D")|| direction.equals("d")){
            this.playD();
        }
    }


    //functions test that moves are valid, are used in the functions above to ensure that no invalid moves are made
    public boolean testW(){
        if (this.playerX -1 < 0){
            return false;

        }   else if(actualBoard[playerX-1][playerY].isWalkable == false){
            return false;
        }
        return true;
    }
    public boolean testA(){
        if (this.playerY -1 < 0){
            return false;

        }   else if(actualBoard[playerX][playerY-1].isWalkable == false){
            return false;
        }
        return true;
    }

    public boolean testS(){

        if (this.playerX + 1 >= rows){
            return false;

        }   else if(actualBoard[playerX+1][playerY].isWalkable == false){
            return false;
        }
        return true;
    }


    public boolean testD(){
        if (this.playerY + 1 >= rows){
            return false;

        }   else if(actualBoard[playerX][playerY+1].isWalkable == false){
            return false;
        }
    return true;
    }

    //combines four previous functions to see if a move is valid

    public boolean isValidMove(String direction){
        if (direction.equals("W")|| direction.equals("w")){
            return this.testW();

        }
        else if (direction.equals("A")|| direction.equals("a")){
            return this.testA();

        }
        else if (direction.equals("S")|| direction.equals("s")){
            return this.testS();

        }
        else if (direction.equals("D")|| direction.equals("d")){
            return this.testD();
        }
        return true;
    }

    //returns the tile the player is currently on
    public Tile returnPlayerTile(){
        return actualBoard[playerX][playerY];
    }

}
