import java.util.ArrayList;
public abstract class game {
    protected static hero[] heroes;
    protected static Board  gameBoard;

    public game (hero[] heroes, Board gameBoard){
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
        monsterGenerator currentGen = new monsterGenerator();
        String [][] filteredMonsters = currentGen.filterMonstersLevel(this.heroMaxLevel());
        for (int i = 0; i < heroes.length; i++){
            currentMonsters[i] = generateRandom.generateRandomWnoHeader(filteredMonsters, filteredMonsters.length);
        }
        ArrayList<monster> inputMonsters  = monsterGenerator.generateMonster(currentMonsters);
        fightInteraction currentFight = new fightInteraction(heroes, inputMonsters);
        boolean returnBool = currentFight.fight();
        return returnBool;


    }

    //enterMarket simulation, utilizes marketINteraction class
    public void enterMarket(){
        int selection = 7;
        while(selection !=-1) {
            System.out.println("Who will enter the store? Enter -1 for all heroes to leave the store");
            selection = input.selectHero(heroes);
            if (selection == -1) {
                return;
            }
            System.out.println("Welcome to my store " + heroes[selection].getName() + "!");

            marketInteraction currentMarket = new marketInteraction(heroes[selection], gameBoard.returnPlayerTile().getContents());
       int currentHeroLeave = 9;
        while (currentHeroLeave != -1){
            System.out.println("Would you like to buy or sell or leave? B/S/L");
            String buyOrSell = input.getLetter();
            while (!buyOrSell.equals("B") && !buyOrSell.equals("S") && !buyOrSell.equals("L")) {
                System.out.println("Please enter a valid input");
                buyOrSell = input.getLetter();
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
