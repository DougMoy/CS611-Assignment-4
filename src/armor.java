public class armor extends item{
    //class represents armor item, extends item because armor is an item
    int damageReduc;
    public armor(String name, int level, int price,int damageReduc){
        super(name, level,price);
        this.damageReduc = damageReduc;
        this.itemDescription = new String[]{name, String.valueOf(price), String.valueOf(level), String.valueOf(damageReduc)};
        this.itemLabels = new String[]{"Name", "Cost", "Level", "Damage Reduction"};

    }
    //the class' useItem function equips the armor

    public void useItem(hero currentHero){
        if(currentHero.setEquipArmor(this)){
            System.out.println("Successfully equipped");
            currentHero.removeItem(this);
        }else{
            System.out.println("Unsuccessfully equipped");
        }
    }


}
