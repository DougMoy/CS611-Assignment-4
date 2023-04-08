import java.util.ArrayList;
public class fireSpell extends spell {
    //fire spell item
    public fireSpell (String name, int level, int price, int damageValue, int manaCost){
        super(name, level, price, damageValue, manaCost);

    }

    //applies spell effect to monster
    public void spellEffect(monster monsterToKill){
        monsterToKill.defense = monsterToKill.defense / 10;
    }

}
