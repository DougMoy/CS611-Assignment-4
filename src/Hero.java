import java.util.ArrayList;
/*
 * GenerateRandom.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * Class for a Hero object.
 * Heroes have a variety of properties, including
 * name, level, health, strength, dexterity, agility, and more.
 * This class is responsible for updating Hero's stats and taking certain actions like equipping items.
 */
public abstract class Hero {
    protected String name;
    protected int level;
    protected int xp;

    protected int hp;

    protected int mana;
    protected int strength;
    protected int dexterity;
    protected int agility;
    protected int gold;
    protected ArrayList<Item> items;

    protected int numHands;
    protected Armor equippedArmor;

    protected ArrayList<Weapon> equippedWeapons;
    protected int itemCount;
    protected boolean fainted;

    protected int defense;
    protected int tempDex;
    protected int tempAgility;

    protected int tempStrength;

    public Hero(String name, int level, int xp, int hp, int mana, int strength, int dexterity, int agility, int gold, ArrayList<Item> items){
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.hp = level * 100;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold= gold;
        this.items = items;
        this.itemCount = 0;
        this.numHands = 2;
        this.equippedArmor = null;
        this.equippedWeapons = new ArrayList<>();
        this.fainted = false;
        this.defense = 0;
        this.tempDex = 0;
        this.tempAgility = 0;
        this.tempStrength = 0;


    }
    public String getName(){
        return this.name;
    }

    public void updateDex(int tempIncrease){
        this.tempDex = tempIncrease;
        this.dexterity = this.dexterity + tempDex;
    }
    public void updateAgility(int tempIncrease){
        this.tempAgility = tempIncrease;
        this.agility = this.agility + tempAgility;
    }
    public void updateStrength(int tempIncrease){
        this.tempStrength = tempIncrease;
        this.strength = this.strength + tempStrength;
    }


    public void resetHero (){
        this.dexterity = this.dexterity - this.tempDex;
        this.strength = this.strength - this.tempStrength;
        this.agility = this.agility - this.tempAgility;
        this.tempDex = 0;
        this.tempAgility = 0;
        this.tempStrength = 0;
    }
    public boolean getFainted(){
        return this.fainted;
    }
    public void setHeroFainted(){
        this.fainted = true;
    }
    public void heroRes(){
        this.fainted = true;
    }

    public int getLevel(){return this.level;}
    public int getGold(){return this.gold;}

    //adds item to inventory
    public void addItem(Item itemToAdd){
        this.items.add(itemToAdd);
        this.gold = this.gold - itemToAdd.getPrice();
    }

    //prints out string representation of hero
    public void printHero(String heroColor){
        System.out.println(heroColor);
        System.out.println("Name: " + this.name+ " HP: " + this.hp +  " Level: " + this.level+ " XP: "+ this.xp + " Mana: " + this.mana + " Strength: " + this.strength + " Agility: " + this.agility+ " Dexterity: " + this.dexterity + " Money: " + this.gold);
        if(this.equippedArmor != null){
            System.out.println("Equipped Armor: " + this.equippedArmor.name);
        }
        if(this.equippedWeapons.size() != 0){
            System.out.println("Equipped Weapons:");
            for(int i = 0; i < equippedWeapons.size(); i++){
                System.out.print(equippedWeapons.get(i).name+ "    ");
            }
        }
        System.out.println("Here is " + this.name + "'s inventory:");
        this.printItems(heroColor);
    }
    //prints out string representation of a hero's items

    public void printItems(String heroColor){
        for (int i = 0; i < items.size(); i++){

            items.get(i).labeledItem(i, heroColor);
        }
        System.out.println(Colors.ANSI_RESET);
    }
    public void printArmorAndWeapons(String heroColor){
        for (int i = 0; i < items.size(); i++){
            if (items.get(i) instanceof Weapon || items.get(i) instanceof Armor) {
                items.get(i).labeledItem(i, heroColor);
            }
            System.out.println(Colors.ANSI_RESET);
        }
    }

    public void printPotions(String heroColor){
        for (int i = 0; i < items.size(); i++){
            if (items.get(i) instanceof Potion) {
                items.get(i).labeledItem(i, heroColor);
            }
            System.out.println(Colors.ANSI_RESET);
        }
    }
    public boolean isPotion(int index){
        if (items.get(index) instanceof Potion){
            return true;
        }
        return false;
    }

    public boolean isIndexArmorOrWeapon(int index){
        if (items.get(index) instanceof Weapon || items.get(index) instanceof Armor ){
            return true;
        }
        return false;
    }
    //removes items from a hero's inventory
    public void removeItem(int i){
        items.remove(i);
    }

    public void removeItem(Item i){
        items.remove(i);
    }
    public int getMana(){
        return this.mana;
    }
    public void setMana(int i){
        this.mana = this.mana -i;
    }

    public void addGold(int i){
        this.gold = this.gold + i;
    }

    public Item getItem (int i){
        return items.get(i);
    }

    public void increaseHpAfterFight(){
        this.hp = this.hp + (this.hp/10);
    }
    public void increaseMpAfterFight(){
        this.mana = this.mana + (this.mana/10);
    }
    public boolean setEquipArmor(Armor equipArmor){
        if (this.equippedArmor != null) {
            this.equippedArmor = equipArmor;
            return true;
        }
        else{
            return false;
        }
    }

    public void increaseXP(int i){
        this.xp = xp + i;
    }

    public void increaseGold(int i){
        this.gold = this.gold +i;
    }

    public void increaseHp (int i){
        this.hp = this.hp +i;
    }

    public void increaseStrength (int i){
        this.strength = this.strength +i;
    }

    public void increaseMana(int i){
        this.mana = this.mana+i;
    }

    public void increaseAgility(int i){
        this.agility = this.agility + i;
    }

    public void increaseDexterity(int i){
        this.dexterity = this.dexterity + i;
    }

    public void increaseDefense(int i){
        this.defense = this.defense + i;
    }
    public void takeDamage(int i){
        double rand = Math.random();
        if (rand <= this.agility *0.0002){
            System.out.println(this.name + " has dodged the attack!");
            return;
        }

        if(this.equippedArmor!= null) {
            this.hp = this.hp - ((i/100) * (1- ((equippedArmor.damageReduc + this.defense) / 3000)));
        }
        else{
            this.hp = this.hp - ((i/100) *(1- (this.defense/3000)));
        }
    }


    public boolean setEquippedWeapons(Weapon weaponTo){
        if(this.numHands >= weaponTo.getHands()) {
            this.equippedWeapons.add(weaponTo);
            this.numHands = this.numHands-weaponTo.getHands();
            return true;
        }
        else{
            return false;
        }

    }

    public int calcWeaponDamage(){
        int damage = 0;
        for(int i = 0; i< equippedWeapons.size(); i++){
            damage = damage + equippedWeapons.get(i).getDamage();
        }
        return damage;
    }
    public int calcDamage(){
        int returnValue = ((calcWeaponDamage() + this.strength) /20);
        return returnValue;
    }

    public void reequipItems(){
        if (equippedArmor!= null) {
            this.items.add(equippedArmor);
            equippedArmor = null;
        }
        for(int i = 0; i < equippedWeapons.size(); i++){
            this.items.add(equippedWeapons.get(i));
            equippedWeapons.remove(i);
        }
    }
    public void reequipArmor(){
        if (equippedArmor!= null) {
            this.items.add(equippedArmor);
            equippedArmor = null;
        }
    }
    public void reequipBothWeapons(){
        for(int i = 0; i < equippedWeapons.size(); i++){
            this.items.add(equippedWeapons.get(i));
            equippedWeapons.remove(i);
        }
    }


    public void checkForLevelUp(){
        if (this.xp >= (this.level * 10)){
            this.xp = 0;
            this.level = level+1;
            levelUp();
        }
    }
    public abstract void levelUp();




}
