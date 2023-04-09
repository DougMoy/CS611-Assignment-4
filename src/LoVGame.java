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
        while(true){
            //heroes take turns
            String userInput = "D";
            for (int i = 0; i < this.heroes.length; i++) {
                Hero h = this.heroes[i];

                gameBoard.printBoard();
                System.out.println("Hero" + i + "'s turn: " + h.getName());
                userInput = Input.userInputLetter().toLowerCase();
                switch (userInput) {
                    case "w","a","s","d" -> {}
                    case "m" -> {}
                    case "i" -> {}
                    case "q" -> {}
                }
            }

            //monsters take turns
            for (int i = 0; i < this.monsters.length; i++){

            }

            break;
        }


        System.out.println("Would you like to play again? Y/N");
        String newVar = Input.getLetter();
        while(!newVar.equals("Y") && !newVar.equals("N")){
            System.out.println("Invalid input, Enter Y/N only");
            newVar = Input.getLetter();
        }
        if (newVar.equals("Y")){
            GameStartMandH.startGame();
        }
        else{
            return;
        }
    }

}
