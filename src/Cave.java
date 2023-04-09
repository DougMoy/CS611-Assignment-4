/*
 * Cave.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The cave object is a subclass extending Tile.
 * Cave spaces increase the agility of any hero inside them.
 * The bonus is removed when the hero leaves the space
 */
public class Cave extends Tile{
    public Cave (int index){
        super(index);
        this.marker = "C";
    }

    @Override
    public void enhanceHeroes(Hero [] heroes) {
        for (int i = 0; i < heroes.length; i++){
            heroes[i].updateAgility(10);
        }
    }
}
