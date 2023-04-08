import java.util.ArrayList;
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
