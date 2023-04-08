public class MAndHGame extends Game {




    public MAndHGame(Hero[] heroes, MonstersAndHeroesBoard gameBoard){
        super(heroes, gameBoard);
    }
    //function that runs the game
    public void runGame(){
        String userInput = "D";
        int heroesAlive = 1;
        while(!userInput.equals("Q") || !userInput.equals("q") || heroesAlive !=1){
            gameBoard.printBoard();
            userInput = Input.userInputLetter();
            if (userInput.equals("W") || userInput.equals("w") || userInput.equals("A") || userInput.equals("a") || userInput.equals("S") || userInput.equals("s") || userInput.equals("D") ||userInput.equals("d")){
                if(gameBoard.isValidMove(userInput) == false) {
                    System.out.println("Your hero can not move here! Please select a different move");
                }
                else{
                    gameBoard.playMoveDirection(userInput);
                    double random = Math.random();
                    if(gameBoard.returnPlayerTile().marker.equals(" ")) {
                        if(random <= .3){
                            System.out.println("OH NO YOU HAVE BEEN ATTACKED!!!");
                            if(this.fightMonsters() == false){
                                System.out.println("You have lost!");
                                break;
                            }
                        }
                    }


                }
            }
            else if(userInput.equals("M") || userInput.equals("m")){
                if (gameBoard.returnPlayerTile().getMarker() == "M"){
                   this.enterMarket();

                }
                else{
                    System.out.println("You are not on a market tile. You shall not pass!");
                }
            }
            else if(userInput.equals("I") || userInput.equals("i")){


                for (int i = 0; i < heroes.length; i++){

                    heroes[i].printHero(Colors.heroColors[i]);
                    System.out.println("");
                }
                System.out.println(Colors.ANSI_RESET);
                System.out.println("Enter Q/q to go back to the main menu");
                String quitVar = Input.getLetter();
                while(!quitVar.equals("Q") && !quitVar.equals("q")){
                    System.out.println("Invalid input, Enter Q/q to go back to the main menu");
                    quitVar = Input.getLetter();
                }
            }


            else if(userInput.equals("Q") || userInput.equals("q")){
                break;
            }
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
