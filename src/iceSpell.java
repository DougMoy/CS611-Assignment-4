public class iceSpell extends spell{
    //represents icespell object
    public iceSpell (String name, int level, int price, int damageValue, int manaCost){
        super(name, level, price, damageValue, manaCost);
    }
    public void spellEffect(monster monsterToKill){
        monsterToKill.damage = monsterToKill.damage /10;
    }
}
