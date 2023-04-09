import java.util.ArrayList;
/*
 * Tile.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The Tile object represents a space on a board.
 * It stores properties like isWalkable and more.
 */
public abstract class Tile {
        //Tile Class, has index and piece.
        protected boolean isPlayerOn;
        protected boolean isWalkable;
        protected String marker;

        private int index;


        public Tile(int index) {
            //initially have no pieces on board when tiles are first made. Pieces have to be put on
            this.index = index;
            this.marker = " ";
            this.isWalkable = true;
            this.isPlayerOn = false;

        }


        public String getMarker() {
            return this.marker;
        }
        //set piece on tile

        public void playerOn() {

            this.isPlayerOn = true;

        }

        public void playerOff() {
            this.isPlayerOn = false;
        }


        public boolean isThePlayerOn() {
            return this.isPlayerOn;
        }



        //tile is empty if no piece is on the tile.




        public void printContents(){}

        public void enhanceHeroes(Hero[] heroes){

        }
        public ArrayList<Item> getContents()

        {
            ArrayList<Item> empty = new ArrayList<>();
            return empty;
        }


    }


