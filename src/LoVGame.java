/*
 * LoVGame.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A subclass of a Game object.
 * Entry point of the Legends of Valor game.
 */
public class LoVGame extends Game {
    protected static Monster[] monsters;
    public LoVGame(Hero[] heroes, LegendsOfValorBoard gameBoard){
        super(heroes, gameBoard);
    }
    //function that runs the game
    public void runGame(){
        String userInput = "D";
        while(userInput != "q"){
            //heroes take turns
            for (int i = 0; i < heroes.length; i++) {
                Hero h = heroes[i];
                boolean valid = false;
                while (!valid) {
                    gameBoard.printBoard();
                    System.out.println("Hero" + i + "'s turn: " + h.getName());
                    userInput = Input.userInputLetter().toLowerCase();
                    switch (userInput) {
                        case "w", "a", "s", "d" -> {
                            if (gameBoard.isValidMove(userInput)) valid = true;
                        }
                        case "m" -> {
                            if (gameBoard.returnPlayerTile() instanceof HeroNexus) valid = true;
                        }
                        case "i" -> {
                            valid = true;
                        }
                        case "q" -> {
                            promptAgain();
                            return;
                        }
                    }
                    if (!valid) System.out.println("Invalid move, please try again.");
                }
                switch (userInput) {
                    case "w","a","s","d" -> {
                        if (gameBoard.isValidMove(userInput)) valid = true;
                    }
                    case "m" -> {if (gameBoard.returnPlayerTile() instanceof HeroNexus) valid = true;
                    }
                    case "i" -> {valid = true;}
                    case "q" -> {promptAgain(); return;}
                }
            }

            //monsters take turns
            for (int i = 0; i < monsters.length; i++){

            }

            break;
        }

        promptAgain();
    }

    private void promptAgain(){
        System.out.println("Would you like to play again? Y/N");
        String newVar = Input.getLetter();
        while(!newVar.equals("Y") && !newVar.equals("N")){
            System.out.println("Invalid input, Enter Y/N only");
            newVar = Input.getLetter();
        }
        if (newVar.equals("Y")){
            //GameStartMandH.startGame();
            //Start game here
        }
        else{
            return;
        }
    }
}
