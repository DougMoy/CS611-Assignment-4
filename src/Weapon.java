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
            System.out.println("Sorry unable to equip this weapon");
        }
    }
}
