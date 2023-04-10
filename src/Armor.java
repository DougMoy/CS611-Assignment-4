/*
 * Armor.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * This class represents equippable armor.
 * Armor is implemented as a subtype of Item. It has an additional stat: damage reduction.
 * Heroes can equip armor as a type of equipment.
 */
public class Armor extends Item {
    //class represents armor item, extends item because armor is an item
    int damageReduc;
    public Armor(String name, int level, int price, int damageReduc){
        super(name, level,price);
        this.damageReduc = damageReduc;
        this.itemDescription = new String[]{name, String.valueOf(price), String.valueOf(level), String.valueOf(damageReduc)};
        this.itemLabels = new String[]{"Name", "Cost", "Level", "Damage Reduction"};

    }
    //the class' useItem function equips the armor

    public void useItem(Hero currentHero){
        if(currentHero.setEquipArmor(this)){
            System.out.println("Successfully equipped");
            currentHero.removeItem(this);
        }else{

            currentHero.removeItem(this);
            currentHero.reequipArmor();
            currentHero.setEquipArmor(this);
        }
    }


}
