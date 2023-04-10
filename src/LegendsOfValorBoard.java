import java.util.ArrayList;
import java.util.List;

public class LegendsOfValorBoard extends Board {
    public int heroIndex;
    public int[] playerXs, playerYs;
    public List<Integer> monsterXs, monsterYs;
    public LegendsOfValorBoard (int rows, int cols){
        super (rows, cols);
        this.heroIndex = 0;
        playerXs = new int[3];
        playerYs = new int[3];
        monsterXs = new ArrayList();
        monsterYs = new ArrayList();
        int count = 0;

        for (int i = 0; i< rows; i++){

            for (int j = 0; j <cols; j++){
                if( i == 0){
                    this.actualBoard[i][j] = new MonsterNexus(count);

                }
                else if (i == rows-1){
                    this.actualBoard[i][j] = new HeroNexus(count);
                }
                else{
                    double prob = Math.random();
                    if (prob<=.2){
                        this.actualBoard[i][j] = new Bush(count);
                    }
                    else if (prob<=.4){
                        this.actualBoard[i][j] = new Cave(count);
                    }
                    else if (prob <=.6){
                        this.actualBoard[i][j] = new Koulou(count);

                    }
                    else {
                        this.actualBoard[i][j] = new CommonSpace(count);
                    }
                }
            }


        }
        for(int i = 0; i < rows; i++){
            this.actualBoard[i][2]= new InaccessibleTile(count);
            this.actualBoard[i][5]= new InaccessibleTile(count);
        }

    }

    //ad hoc method to use parent methods.
    public void setHero(int i) {
        assert i > 0 && i < 3;
        playerXs[heroIndex] = playerX;
        playerYs[heroIndex] = playerY;
        heroIndex = i;
        playerX = playerXs[i];
        playerY = playerYs[i];
    }

    public boolean checkHeroWin(){
        //check for win function for heroes, allows for expandability because not hard coding where monster nexi are
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(this.actualBoard[i][j].isPlayerOn = true && this.actualBoard[i][j] instanceof MonsterNexus){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkMonsterWin(){
        for (int i = 0; i < monsterXs.size(); i++){
            for (int j = 0; j < monsterYs.size(); i ++){
                if (this.actualBoard[monsterXs.get(i)][monsterYs.get(j)] instanceof HeroNexus){
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean isValidMove(String direction) {
        if (super.isValidMove(direction)){
            //test collision with monsters and players
            for (int i = 0; i < monsterXs.size(); i++){
                switch(direction){
                    case "w" -> {if (playerX - 1 == monsterXs.get(i) && playerY == monsterYs.get(i)) {
                        return false;
                        }
                    }
                    case "a" -> {if (playerX == monsterXs.get(i) && playerY - 1 == monsterYs.get(i)) {
                        return false;
                        }
                    }
                    case "s" -> {if (playerX + 1 == monsterXs.get(i) && playerY == monsterYs.get(i)) {
                        return false;
                        }
                    }
                    case "d" -> {if (playerX == monsterXs.get(i) && playerY + 1 == monsterYs.get(i)) {
                        return false;
                        }
                    }
                }
            }
            for (int i = 0; i < playerXs.length; i++){
                if (i == heroIndex) continue;
                switch(direction){
                    case "w" -> {if (playerX - 1 == playerXs[i] && playerY == playerYs[i])
                        return false;
                    }
                    case "a" -> {if (playerX == playerXs[i] && playerY - 1 == playerYs[i])
                        return false;
                    }
                    case "s" -> {if (playerX + 1 == playerXs[i] && playerY == playerYs[i])
                        return false;
                    }
                    case "d" -> {if (playerX == playerXs[i] && playerY + 1 == playerYs[i])
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
