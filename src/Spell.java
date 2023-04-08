public abstract class Spell extends Item {

    protected int damageValue;
    protected int manaCost;

    private String type;
    public Spell(String name, int level, int price, int damageValue, int manaCost){
        super(name,level,price);
        this.manaCost = manaCost;
        this.itemDescription = new String[]{name, String.valueOf(price), String.valueOf(level), String.valueOf(damageValue), String.valueOf(manaCost)};
        this.itemLabels = new String[]{"Name", "Cost", "Level", "Damage", "Mana Cost"};
    }

    public void useItem(Hero currentHero){
        if (currentHero.getMana() < this.manaCost){
            System.out.println("Sorry unable to cast this spell");
        }else {
            FightInteraction.applySpell(this);
            currentHero.removeItem(this);
            currentHero.setMana(this.manaCost);
        }
    }

    public abstract void spellEffect(Monster monsterToKill);

}
