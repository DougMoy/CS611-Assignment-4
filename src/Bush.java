public class Bush extends Tile{
    public Bush (int index){
        super(index);
        this.marker = "B";

    }

    @Override
    public void enhanceHeroes(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++){
            heroes[i].updateDex(10);
        }
    }
}
