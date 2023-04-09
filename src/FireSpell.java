/*
 * FireSpell.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The FireSpell class is a subclass extending Spell extending Item.
 * It is a damaging spell with a special effect of reducing the monster's defense.
 */
public class FireSpell extends Spell {
    //fire spell item
    public FireSpell(String name, int level, int price, int damageValue, int manaCost){
        super(name, level, price, damageValue, manaCost);

    }

    //applies spell effect to monster
    public void spellEffect(Monster monsterToKill){
        monsterToKill.defense = monsterToKill.defense / 10;
    }

}
