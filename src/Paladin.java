import java.util.ArrayList;
/*
 * Paladin.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A subclass extending the Hero class.
 * Paladins are favored on strength and dexterity.
 */
public class Paladin extends Hero {
    public Paladin(String name, int level, int xp, int hp, int mana, int strength, int dexterity, int agility, int gold, ArrayList<Item> items){
        super(name, level, xp,hp,mana,strength,dexterity,agility, gold, items);
    }
    public void levelUp(){
        this.hp = this.level * 100;
        this.mana = this.mana + (this.mana/10);
        this.strength = this.strength + (this.strength/10);
        this.dexterity = this.dexterity + (this.dexterity/10);
        this.agility = this.agility + (this.agility/20);
    }
}
