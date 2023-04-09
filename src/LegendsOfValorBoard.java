public class LegendsOfValorBoard extends Board {
    int heroIndex;
    int[] playerXs, playerYs;
    int[] monsterXs, monsterYs;
    public LegendsOfValorBoard (int rows, int cols){
        super (rows, cols);
        this.heroIndex = 0;
        int[] playerXs = new int[3], playerYs = new int[3];
        int[] monsterXs = new int[3], monsterYs = new int[3];
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
}
