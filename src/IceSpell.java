/*
 * IceSpell.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The IceSpell class is a subclass extending Spell extending Item.
 * It is a damaging spell with a special effect of reducing the monster's attack.
 */
public class IceSpell extends Spell {
    //represents icespell object
    public IceSpell(String name, int level, int price, int damageValue, int manaCost){
        super(name, level, price, damageValue, manaCost);
    }
    public void spellEffect(Monster monsterToKill){
        monsterToKill.damage = monsterToKill.damage /10;
    }
}
