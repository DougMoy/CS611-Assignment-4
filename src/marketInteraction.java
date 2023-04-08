import java.util.ArrayList;
public class marketInteraction extends interaction{


    private ArrayList<item> marketItems;

    public marketInteraction(hero currentHero, ArrayList<item> marketItems){
        super(currentHero);
        this.marketItems = marketItems;
    }

    public boolean verifyBuy(int marketIndex){
        if (currentHero.getLevel() < marketItems.get(marketIndex).getLevel()){
            return false;
        }
        if (currentHero.getGold() < marketItems.get(marketIndex).getPrice()){
            return false;
        }

        return true;

    }
    public int buyItem(){
        int marketIndex = input.getInt();
        if (marketIndex == -1){
            return -1;
        }
        while(marketIndex < -1 || marketIndex >= marketItems.size()){

            System.out.println("Sorry please enter a valid input");
            marketIndex = input.getInt();
        }
        if (verifyBuy(marketIndex) == false){
            System.out.println("You can't buy this item! :'(");
            return 9;
        }
        else {
            System.out.println("You have successfully bought " + marketItems.get(marketIndex).name + "!");

            currentHero.addItem(marketItems.get(marketIndex));
        }
        return 9;
    }

    public int sellItem(){
        currentHero.printItems(Colors.ANSI_WHITE);
        int indexSell = input.getInt();


        while (indexSell < -1 || indexSell >= currentHero.items.size()){
            System.out.println("Please enter a valid input");
            indexSell = input.getInt();
        };
        if (indexSell == -1){
            return -1;
        }


        currentHero.addGold((currentHero.getItem(indexSell).getPrice())/2);
        if(!marketItems.contains(currentHero.getItem(indexSell))) {
            marketItems.add(currentHero.getItem(indexSell));
        }
        System.out.println("You have successfully sold your item");
        currentHero.removeItem(indexSell);

        return 9;

    }



}
