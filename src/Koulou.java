public class Koulou extends Tile{
    public Koulou (int index){
        super(index);
        this.marker = "K";
    }

    public void enhanceHeroes(Hero [] heroes){
        for (int i = 0; i < heroes.length; i++){
            heroes[i].updateStrength(10);
        }
    }

}
