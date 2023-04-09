/*
 * GameStartMandH.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * Entry point to the Monsters and Heroes game.
 */
public class GameStartMandH {
    //function that gets in all needed info to start the game
    public static void startGame(){
        System.out.println("WELCOME TO MONSTERS AND HEROES");
        Hero[] gameHeroes = Input.getHeroes();
        System.out.println("Here are your heroes: ");
        for (int i = 0; i < gameHeroes.length; i++){
            System.out.println(gameHeroes[i].getName());
        }

        System.out.println("How many rows would you like your map to have?");
        int rows = Input.getInt();
        System.out.println("How many columns would you like your map to have?");
        int cols = Input.getInt();
        MonstersAndHeroesBoard gameBoard = new MonstersAndHeroesBoard(rows,cols);
        MAndHGame realGame = new MAndHGame(gameHeroes, gameBoard);
        System.out.println("Welcome to Monsters and Heroes!");
        realGame.runGame();

    }


}
