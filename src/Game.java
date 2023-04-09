import java.util.ArrayList;
/*
 * Game.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * Abstract class that represents a playable game.
 * Game supports Heroes on a Board, taking several types of actions
 * such as fighting monsters and buying from a market.
 */
public abstract class Game {
    protected static Hero[] heroes;
    protected static Board gameBoard;

    public Game(Hero[] heroes, Board gameBoard){
        this.heroes = heroes;
        this.gameBoard = gameBoard;
    }


    //find hero max level
    public int heroMaxLevel(){
        int currentMax = 1;
        for (int i = 0; i < heroes.length; i++){
            if(heroes[i].getLevel() > currentMax){
                currentMax = heroes[i].getLevel();
            }
        }
        return currentMax;
    }
    //fight monsters function, utilizes fightInteraction class
    public boolean fightMonsters (){
        String [][] currentMonsters = new String [heroes.length][5];
        MonsterGenerator currentGen = new MonsterGenerator();
        String [][] filteredMonsters = currentGen.filterMonstersLevel(this.heroMaxLevel());
        for (int i = 0; i < heroes.length; i++){
            currentMonsters[i] = GenerateRandom.generateRandomWnoHeader(filteredMonsters, filteredMonsters.length);
        }
        ArrayList<Monster> inputMonsters  = MonsterGenerator.generateMonster(currentMonsters);
        FightInteraction currentFight = new FightInteraction(heroes, inputMonsters);
        boolean returnBool = currentFight.fight();
        return returnBool;


    }

    //enterMarket simulation, utilizes marketINteraction class
    public void enterMarket(){
        int selection = 7;
        while(selection !=-1) {
            System.out.println("Who will enter the store? Enter -1 for all heroes to leave the store");
            selection = Input.selectHero(heroes);
            if (selection == -1) {
                return;
            }
            System.out.println("Welcome to my store " + heroes[selection].getName() + "!");

            MarketInteraction currentMarket = new MarketInteraction(heroes[selection], gameBoard.returnPlayerTile().getContents());
       int currentHeroLeave = 9;
        while (currentHeroLeave != -1){
            System.out.println("Would you like to buy or sell or leave? B/S/L");
            String buyOrSell = Input.getLetter();
            while (!buyOrSell.equals("B") && !buyOrSell.equals("S") && !buyOrSell.equals("L")) {
                System.out.println("Please enter a valid input");
                buyOrSell = Input.getLetter();
            }
            if (buyOrSell.equals("L")){
                currentHeroLeave = -1;
            }
            else if (buyOrSell.equals("B")) {
                System.out.println("What would you like to buy? Enter -1 for the current hero to leave");
                gameBoard.returnPlayerTile().printContents();
               currentHeroLeave = currentMarket.buyItem();
            }
            else if(heroes[selection].items.size() == 0){
                System.out.println("You have no items to sell!");

            }
            else {

                System.out.println("What would you like to sell? Enter -1 for the current hero to leave" );
                currentHeroLeave = currentMarket.sellItem();

            }
        }
        }
    }
}
