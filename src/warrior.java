import java.util.ArrayList;
public class warrior extends hero {
    public warrior(String name, int level, int xp, int hp, int mana, int strength, int dexterity, int agility, int gold, ArrayList<item> items){
        super(name, level, xp,hp,mana,strength,dexterity,agility, gold, items);
    }
    public void levelUp(){
        this.hp = this.level * 100;
        this.mana = this.mana + (this.mana/10);
        this.strength = this.strength + (this.strength/10);
        this.dexterity = this.dexterity + (this.dexterity/20);
        this.agility = this.agility + (this.agility/10);
    }
}
