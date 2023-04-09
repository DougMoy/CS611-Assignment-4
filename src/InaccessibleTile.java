/*
 * InaccessibleTile.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The InaccessibleTile object is a subclass extending Tile.
 * It is an unWalkable tile.
 */
public class InaccessibleTile extends Tile{
    //represents inaccessebile tile
    public InaccessibleTile(int index){
        super(index);
        this.isWalkable = false;
        this.marker = "+";
    }

}
