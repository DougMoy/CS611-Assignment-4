public class IceSpell extends Spell {
    //represents icespell object
    public IceSpell(String name, int level, int price, int damageValue, int manaCost){
        super(name, level, price, damageValue, manaCost);
    }
    public void spellEffect(Monster monsterToKill){
        monsterToKill.damage = monsterToKill.damage /10;
    }
}
