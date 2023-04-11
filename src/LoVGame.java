import java.util.ArrayList;
import java.util.List;

/*
 * LoVGame.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A subclass of a Game object.
 * Entry point of the Legends of Valor game.
 */
public class LoVGame extends Game {
    //indices of heroes corresponds with lane.
    protected static List<Monster> monsters;
    protected int turn;
    public LoVGame(Hero[] heroes, LegendsOfValorBoard gameBoard){
        super(heroes, gameBoard);
        turn = 0;
        monsters = new ArrayList<>();
    }
    //function that runs the game
    public void runGame(){
        String userInput = "D";
        while(userInput != "q"){
            //every three turns spawn new monster
            if (turn % 3 == 0) {
                LoVInteraction.spawnMonsters((LegendsOfValorBoard) gameBoard, heroes, monsters, 1);
            }

            //heroes take turns
            for (int i = 0; i < heroes.length; i++) {
                Hero h = heroes[i];
                ((LegendsOfValorBoard)gameBoard).setHero(i);

                //wait for valid input
                boolean valid = false;
                while (!valid) {
                    gameBoard.printBoard();
                    System.out.println(Colors.heroColors[i]+ "Hero " + (i + 1) + "'s turn" + Colors.ANSI_RESET + ": " + h.getName());
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
                                System.out.println("Which item would you like to equip?, enter -1 to leave this menu");
                                h.printArmorAndWeapons(Colors.heroColors[i]);
                                int userIndex = Input.getInt();
                                while(h.isIndexArmorOrWeapon(userIndex) == false || userIndex != -1){
                                    System.out.println("Please select a valid index that is armor or a weapon, or -1 to leave");
                                    userIndex = Input.getInt();
                                }
                                if(userIndex == -1){
                                    continue;
                                }
                                h.getItem(userIndex).useItem(h);

                            }
                            continue;
                        }
                        case "p" -> {
                            System.out.println("What potion do you want to consume? enter -1 to leave this menu");
                            h.printPotions(Colors.heroColors[i]);
                            int userIndex = Input.getInt();
                            while(h.isPotion(userIndex) == false || userIndex != -1){
                                System.out.println("Please select a valid index that is armor or a weapon, or -1 to leave");
                                userIndex = Input.getInt();
                            }
                            if(userIndex == -1){
                                continue;
                            }
                            else{
                                h.getItem(userIndex).useItem(h);
                                valid = true;
                            }

                        }
                        case "t", "r" -> {
                            valid = true;
                        }
                        case "f" -> {
                            if (LoVInteraction.hasMonsterNearby((LegendsOfValorBoard) gameBoard,
                                    heroes, monsters, i, 1)){
                                valid = true;
                            }
                            else {
                                System.out.println("No valid targets in range.");
                            }
                        }
                        case "g" -> {
                            if (LoVInteraction.hasMonsterNearby((LegendsOfValorBoard) gameBoard,
                                    heroes, monsters, i, 2)){
                                valid = true;
                            }
                            else {
                                System.out.println("No valid targets in range.");
                            }
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
                       if (((LegendsOfValorBoard) gameBoard).checkHeroWin() == true){
                           //Heroes have won;
                           System.out.println("CONGRATS ON WINNING LEGENDS OF VALOR");
                           break;
                       }
                    }
                    case "f" -> {
                        LoVInteraction.heroAttacks((LegendsOfValorBoard) gameBoard, heroes, monsters, i);
                    }
                    case "g" -> {
                        LoVInteraction.heroCastsSpell((LegendsOfValorBoard) gameBoard, heroes, monsters, i);
                    }
                    case "r" -> {
                        if (((LegendsOfValorBoard)gameBoard).recall(i)){}
                        else {
                            System.out.println("You attempt to violate the Pauli exclusion principle.");
                            System.out.println("You waste your turn (Nexus occupied).");
                        }
                    }
                    case "t" -> {
                        //TODO: implement teleport
                    }

                }
            }
            for (int i = 0; i < heroes.length; i++){
                heroes[i].increaseHPandMANAafterRound();
            }

            //monsters take turns
            for (int i = 0; i < monsters.size(); i++){

                //TODO: implement monster turns
                //TODO: heroes that die go back to nexus
            }

            if (((LegendsOfValorBoard) gameBoard).checkMonsterWin()){
                System.out.println("YOU HAVE LOST!!!");
                break;
            }
            turn++;
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
            GameStart.startGameLOV();
        }
        else{
            return;
        }
    }
}
