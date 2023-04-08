public abstract class spell extends item{

    protected int damageValue;
    protected int manaCost;

    private String type;
    public spell (String name, int level, int price, int damageValue, int manaCost){
        super(name,level,price);
        this.manaCost = manaCost;
        this.itemDescription = new String[]{name, String.valueOf(price), String.valueOf(level), String.valueOf(damageValue), String.valueOf(manaCost)};
        this.itemLabels = new String[]{"Name", "Cost", "Level", "Damage", "Mana Cost"};
    }

    public void useItem(hero currentHero){
        if (currentHero.getMana() < this.manaCost){
            System.out.println("Sorry unable to cast this spell");
        }else {
            fightInteraction.applySpell(this);
            currentHero.removeItem(this);
            currentHero.setMana(this.manaCost);
        }
    }

    public abstract void spellEffect(monster monsterToKill);

}
