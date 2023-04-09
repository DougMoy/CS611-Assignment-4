/*
 * Monster.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * Class for a Monster object.
 * Heroes have a variety of properties, including
 * name, level, damage, and more.
 * This class is responsible for updating Monster's stats such as taking damage.
 */
public class Monster {

    protected String name;
    protected int level;
    protected int damage;
    protected int defense;
    protected int dodgeChance;
    protected int hp;
    protected String[] monsterDescription;
    protected String[] monsterLabel;
    //init monster
    public Monster(String name, int level, int damage, int defense, int dodgeChance){
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.hp = level*100;
        this.monsterDescription = new String[] {name, Integer.toString(hp),Integer.toString(level), Integer.toString(damage), Integer.toString(defense), Integer.toString(dodgeChance)};
        this.monsterLabel = new String[] {"Name", "HP","Level", "Damage", "Defense", "Dodge Chance"};
    }

    public String[] getMonsterDescription(){
        return this.monsterDescription;
    }

    public String [] getMonsterLabel(){
        return this.monsterLabel;
    }
    //used to print string represenation of monster
    public void printMonster(){
        System.out.println("Name: " + this.name+ " HP:"+this.hp+ " Level: " + this.level+ " Damage: "+ this.damage + " Dodge Chance: " + this.dodgeChance);
    }
    public int getHP(){
        return this.hp;
    }
    //function that inflcits damage on monster
    public void takeDamage(int damage){
        double randomV = Math.random();
        if(randomV > this.dodgeChance * 0.01){ //attack success
            this.hp = this.hp - ((1-(this.defense/10000))*damage);
        }
        else{
            System.out.println(this.name + " Has dodged the attack!");
        }
    }
    //same as above, but monster can't dodge. Used for spells.
    public void takeGuarenteedDamage(int damage){
        this.hp = this.hp - ((1-(this.defense/10000))*damage);
    }
}
