/*
 * Interaction.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * Interactions are objects responsible for handling player behavior.
 */
public abstract class Interaction {
    protected Hero currentHero;
    public Interaction(Hero currentHero){
        this.currentHero=currentHero;
    }
}
