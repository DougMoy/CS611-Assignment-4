public class potion extends item{

    String attribute;
    int increase;



    public potion (String name, int level, int price, int increase, String attribute){
        super(name,level,price);
        this.increase = increase;
        this.attribute = attribute;
        this.itemDescription = new String []{name, String.valueOf(price), String.valueOf(level), String.valueOf(increase),attribute };
        this.itemLabels = new String[]{"Name", "Cost", "Level", "Attribute Increase", "Attribute Affected"};
    }

    //use Item simulates using the potion on the current hero
    public void useItem(hero currentHero){
        if(this.attribute.equals("Health")){
            currentHero.increaseHp(this.increase);
        }
        else if (this.attribute.equals("Strength")){
            currentHero.increaseStrength(this.increase);
        }
        else if(this.attribute.equals("Mana")){
            currentHero.increaseMana(this.increase);
        }
        else if (this.attribute.equals("Agility")){
            currentHero.increaseAgility(this.increase);

        }
        else if(this.attribute.equals("Health/Mana/Strength/Agility")){
            currentHero.increaseHp(this.increase);
            currentHero.increaseMana(this.increase);
            currentHero.increaseStrength(this.increase);
            currentHero.increaseAgility(this.increase);
        }
        else if(this.attribute.equals("Health/Mana/Strength/Dexterity/Defense/Agility")){
            currentHero.increaseHp(this.increase);
            currentHero.increaseMana(this.increase);
            currentHero.increaseStrength(this.increase);
            currentHero.increaseAgility(this.increase);
            currentHero.increaseDefense(this.increase);
            currentHero.increaseDexterity(this.increase);
        }
        currentHero.removeItem(this);
    }


}
