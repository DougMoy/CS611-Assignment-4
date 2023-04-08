
   import java.util.ArrayList;
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


        public ArrayList<item> getContents()

        {
            ArrayList<item> empty = new ArrayList<>();
            return empty;
        }


    }


