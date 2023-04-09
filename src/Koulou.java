/*
 * Koulou.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The Koulou object is a subclass extending Tile.
 * Koulou spaces increase the strength of any hero inside them.
 * The bonus is removed when the hero leaves the space
 */
public class Koulou extends Tile{
    public Koulou (int index){
        super(index);
        this.marker = "K";
    }

    public void enhanceHeroes(Hero [] heroes){
        for (int i = 0; i < heroes.length; i++){
            heroes[i].updateStrength(10);
        }
    }

}
