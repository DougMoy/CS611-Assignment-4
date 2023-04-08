public class InaccessibleTile extends Tile{
    //represents inaccessebile tile
    public InaccessibleTile(int index){
        super(index);
        this.isWalkable = false;
        this.marker = "+";
    }

}
