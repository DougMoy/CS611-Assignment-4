public class GameChooser {
    public static void chooseGame(){
        System.out.println("Which game would you like to play?");
        System.out.println("1. Monsters and Heroes");
        System.out.println("2. Legends of Valor");
        int getInt = Input.getInt();

        while(getInt != 1 && getInt !=2){
            System.out.println("Please enter a valid game selection");
            getInt = Input.getInt();

        }

        if(getInt == 1){
            GameStart.startGameMandH();
        }
        else if (getInt == 2){
            GameStart.startGameLOV();
        }
    }
}
