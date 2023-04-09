/*
 * LightningSpell.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * The LightningSpell class is a subclass extending Spell extending Item.
 * It is a damaging spell with a special effect of reducing the monster's dodge chance.
 */
public class LightningSpell extends Spell {
    public LightningSpell(String name, int level, int price, int damageValue, int manaCost){
        super(name, level, price, damageValue, manaCost);
    }

    public void spellEffect(Monster monsterToKill){
        monsterToKill.dodgeChance = monsterToKill.dodgeChance /10;
    }

}
