/*
 * MonstersAndHeroesBoard.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A subclass of the Board class.
 * Responsible for initializing the board with a variety of different tiles.
 */
public class MonstersAndHeroesBoard extends Board{
    //generates monstersAndHeroes board
    public MonstersAndHeroesBoard(int rows, int cols){
        super(rows, cols);
        int count = 0;



        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {


                double prob = Math.random();
                if(i == 0 && j ==0){
                    this.actualBoard[i][j] = new CommonSpace(count);
                    this.actualBoard[i][j].playerOn();

                }
                else if(prob <= .2){
                    this.actualBoard[i][j] = new InaccessibleTile(count);
                }
                else if(prob > .2 && prob <=.5 ){
                    this.actualBoard[i][j] = new MarketTile(count);
                }
                else{
                    this.actualBoard[i][j] = new CommonSpace(count);
                }

                count = count + 1;

            }

        }


    }




}
