public class Cave extends Tile{
    public Cave (int index){
        super(index);
        this.marker = "C";
    }

    @Override
    public void enhanceHeroes(Hero [] heroes) {
        for (int i = 0; i < heroes.length; i++){
            heroes[i].updateAgility(10);
        }
    }
}
