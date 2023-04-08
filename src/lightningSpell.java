public class lightningSpell extends spell{
    public lightningSpell (String name, int level, int price, int damageValue, int manaCost){
        super(name, level, price, damageValue, manaCost);
    }

    public void spellEffect(monster monsterToKill){
        monsterToKill.dodgeChance = monsterToKill.dodgeChance /10;
    }

}
