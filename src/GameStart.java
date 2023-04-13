/*
 * GameStart.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * Entry point to the Monsters and Heroes game.
 */
public class GameStart{
    //function that gets in all needed info to start the game
    public static void startGameMandH(){
        System.out.println("WELCOME TO MONSTERS AND HEROES");

        Hero [] gameHeroes = getAndPrintHeroes();
        int rows = getRow();
        int cols = getCol();

        MonstersAndHeroesBoard gameBoard = new MonstersAndHeroesBoard(rows,cols);
        MAndHGame realGame = new MAndHGame(gameHeroes, gameBoard);
        System.out.println("Welcome to Monsters and Heroes!");
        realGame.runGame();

    }
    public static void startGameLOV(){
        Display d = new Display();
        SpriteDisplayer title = new SpriteDisplayer(d, 0,0, "rsc/title.txt");
        d.add(title);
        d.render();
        d.showScreen();
        Input.getLetter();

        System.out.println("WELCOME TO LEGENDS OF VALOR");

        Hero[] gameHeroes = getAndPrintHeroes();
        int rows = getRow();
        int cols = 8;

        LegendsOfValorBoard gameBoard = new LegendsOfValorBoard(rows,cols);
        LoVGame realGame = new LoVGame(gameHeroes, gameBoard);
        System.out.println("Welcome to Legends of Valor");
        realGame.runGame();
    }
    private static int getRow(){
        int rows = -1;
        while (true) {
            System.out.println("How many rows would you like your map to have?");
            rows = Input.getInt();
            if (rows < 3) {
                System.out.println("Enter at least 3 rows.");
            }
            else {
                break;
            }
        }
        return rows;
    }
    private static int getCol(){
        int cols = -1;
        while (true) {
            System.out.println("How many columns would you like your map to have?");
            cols = Input.getInt();
            if (cols < 3) {
                System.out.println("Enter at least 3 columns.");
            }
            else {
                break;
            }
        }
        return cols;
    }

    private static Hero[] getAndPrintHeroes(){
        //Hero[] gameHeroes = Input.getHeroes(max);
        Hero[] gameHeroes = new Hero[3];
        for (int i = 0; i < 3; i++){
            gameHeroes[i] = Input.getHero();
        }
        System.out.println("Here are your heroes: ");
        for (int i = 0; i < gameHeroes.length; i++){
            System.out.println(gameHeroes[i].getName());
        }
        return gameHeroes;
    }


}
