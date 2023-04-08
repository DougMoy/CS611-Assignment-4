public class gameStartMandH  {
    //function that gets in all needed info to start the game
    public static void startGame(){
        System.out.println("WELCOME TO MONSTERS AND HEROES");
        hero[] gameHeroes = input.getHeroes();
        System.out.println("Here are your heroes: ");
        for (int i = 0; i < gameHeroes.length; i++){
            System.out.println(gameHeroes[i].getName());
        }

        System.out.println("How many rows would you like your map to have?");
        int rows = input.getInt();
        System.out.println("How many columns would you like your map to have?");
        int cols = input.getInt();
        monstersAndHeroesBoard gameBoard = new monstersAndHeroesBoard(rows,cols);
        mAndHGame realGame = new mAndHGame(gameHeroes, gameBoard);
        System.out.println("Welcome to Monsters and Heroes!");
        realGame.runGame();

    }


}
