/*
 * Bush.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The bush object is a subclass extending Tile.
 * Bush spaces increase the dexterity of any hero inside them.
 * The bonus is removed when the hero leaves the space.
 */
public class Bush extends Tile{
    public Bush (int index){
        super(index);
        this.marker = "B";

    }

    @Override
    public void enhanceHero(Hero indivHero){
        indivHero.increaseDexterity(10);
    }
}
