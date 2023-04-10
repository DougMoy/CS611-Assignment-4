/*
 * Weapon.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * This class represents equippable weapons.
 * Weapon is implemented as a subtype of Item. It has a damage and hand usage.
 * Heroes can equip weapons as a type of equipment.
 */
public class Weapon extends Item {
    private int damage;
    private int hands;

    public Weapon(String name, int level, int price, int damage, int hands){
        super(name,level,price);
        this.damage = damage;
        this.hands = hands;
        this.itemDescription = new String[]{name, String.valueOf(price), String.valueOf(level), String.valueOf(damage), String.valueOf(hands)};
        this.itemLabels = new String[] {"Name", "Cost", "Level", "Damage", "Hands"};

    }

    public int getDamage (){
        return this.damage;
    }

    public int getHands(){
        return this.hands;
    }

    public void useItem(Hero currentHero)
    {
        if(currentHero.setEquippedWeapons(this)){
            System.out.println("Successfully equipped item");
            currentHero.removeItem(this);
        }else{

            if (this.getHands() == 2){

                currentHero.removeItem(this);
                currentHero.reequipBothWeapons();
                currentHero.setEquippedWeapons(this);

            }
            else if(this.getHands() == 1){
                System.out.println("Please select a weapon to unequip so the new weapon can be equipped");
                for (int i = 0; i < currentHero.equippedWeapons.size(); i++){
                    System.out.println("[" + i +"] "+ currentHero.equippedWeapons.get(i).name);
                }
                int userInput = Input.getInt();
                while(userInput < 0 && userInput >= currentHero.equippedWeapons.size()){
                    System.out.println("Please select a valid weapon to unequip");
                    userInput = Input.getInt();

                }
                currentHero.removeItem(this);
                currentHero.equippedWeapons.remove(userInput);
                currentHero.setEquippedWeapons(this);

            }


        }
    }
}
