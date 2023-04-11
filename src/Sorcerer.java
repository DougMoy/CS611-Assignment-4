import java.util.ArrayList;
/*
 * Sorcerer.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A subclass extending the Hero class.
 * Sorcerers are favored on dexterity and agility.
 */
public class Sorcerer extends Hero {
    public Sorcerer(String name, int level, int xp, int hp, int mana, int strength, int dexterity, int agility, int gold, Inventory items){
        super(name, level, xp,hp,mana,strength,dexterity,agility, gold, items);
    }

    public void levelUp(){
        this.hp = this.level * 100;
        this.mana = this.mana + (this.mana/10);
        this.strength = this.strength + (this.strength/20);
        this.dexterity = this.dexterity + (this.dexterity/10);
        this.agility = this.agility + (this.agility/10);
    }

}
