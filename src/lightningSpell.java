public class lightningSpell extends Spell {
    public lightningSpell (String name, int level, int price, int damageValue, int manaCost){
        super(name, level, price, damageValue, manaCost);
    }

    public void spellEffect(Monster monsterToKill){
        monsterToKill.dodgeChance = monsterToKill.dodgeChance /10;
    }

}
