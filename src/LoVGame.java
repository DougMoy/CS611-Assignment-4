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

                //wait for valid input
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
                            //TODO: only allow current hero should be done
                            if (gameBoard.returnPlayerTile() instanceof HeroNexus) this.enterMarketIndividual(h);
                            continue;
                        }
                        case "i" -> {
                            //TODO: allow equipment swapping
                            for (int id = 0; id < heroes.length; id++){
                                heroes[id].printHero(Colors.heroColors[id]);
                                System.out.println("");
                            }
                            System.out.println(Colors.ANSI_RESET);
                            System.out.println("Enter Q/q to go back to the main menu or P/p to swap equipped items");
                            String quitVar = Input.getLetter();
                            while(!quitVar.equals("Q") && !quitVar.equals("q") && !quitVar.equals("P") && !quitVar.equals("p")){
                                System.out.println("Invalid input, Enter Q/q to go back to the main menu or P/p to swap equipped items");
                                quitVar = Input.getLetter();
                            }
                            if(quitVar.equals("P") || quitVar.equals("p")){
                                System.out.println("Which item would you like to equip?");
                                h.printArmorAndWeapons(Colors.heroColors[i]);
                                int userIndex = Input.getInt();
                                while(h.isIndexArmorOrWeapon(userIndex) == false){
                                    System.out.println("Please select a valid index that is armor or a weapon");
                                    userIndex = Input.getInt();
                                }
                                if(h.equippedArmor == null && h.items.get(userIndex) instanceof Armor){
                                    h.items.get(userIndex).useItem(h);
                                }
                                else if(h.equippedArmor!= null && h.items.get(userIndex) instanceof Armor){

                                }


                            }
                            continue;
                        }
                        case "f", "g", "t", "r" -> {
                            valid = true;
                        }
                        case "q" -> {
                            promptAgain();
                            return;
                        }
                    }
                    if (!valid) System.out.println("Invalid move, please try again.");
                }
                //execute action
                switch (userInput) {
                    case "w","a","s","d" -> {
                        gameBoard.playMoveDirection(userInput);
                    }
                    case "f" -> {
                        //TODO: implement attacking
                    }
                    case "g" -> {
                        //TODO: implement spell casting
                    }
                    case "r" -> {
                        //TODO: implement recall
                    }
                    case "t" -> {
                        //TODO: implement teleport
                    }
                }
            }

            //monsters take turns
            for (int i = 0; i < monsters.length; i++){
                //TODO: implement monster turns
            }

            //TODO: check for either side's victory, i.e. in opposing nexus
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
            //TODO: include game starting
        }
        else{
            return;
        }
    }
}
