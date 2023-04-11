import java.util.ArrayList;
/*
 * FightInteraction.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A FightInteraction is a subclass extending Interaction
 * The FightInteraction class is responsible for player combat.
 * An array of Heros fight an array of Monsters until either team is fainted.
 */
public class FightInteraction extends Interaction{
    private Hero[] currentHeroes;
    private static ArrayList<Monster> monsters;
    private static Monster[] arrayMonsters;

    private static Hero publicHero;

    private int numberMonstersInit;
    private int monsterLevel;
    //fight interaction takes in the heroes that are fighting and pits them against the monsters.
    public FightInteraction(Hero[]currentHeroes, ArrayList<Monster>  monsters){
        super(null);
        this.currentHeroes= currentHeroes;
        this.monsters = monsters;
        this.arrayMonsters = new Monster[monsters.size()];
        this.updateArrayMonsters();
        this.publicHero = currentHeroes[0];
        this.numberMonstersInit = monsters.size();
        this.monsterLevel = monsters.get(0).level;




    }
    //updates array representaion so that it is accurate.
    public static void updateArrayMonsters(){
        for (int i = 0; i < monsters.size(); i++){
            arrayMonsters[i] = monsters.get(i);
        }
    }
    //checks to see if all heroes are fainted
    public boolean checkFaintedHeroes(){
        int count =0;
        for (int i = 0; i < currentHeroes.length; i++){
            if(currentHeroes[i].fainted == true){
                count = count + 1;
            }
        }

        return (count == currentHeroes.length);
    }
    //fight function, schedules the fight until either all the heroes are fainted, or all the monsters are dead
    public boolean fight(){

    while(checkFaintedHeroes() == false){

        for (int i = 0; i < currentHeroes.length; i ++){
            if(currentHeroes[i].getFainted() == true){
                System.out.println(currentHeroes[i].getName() + "! You have fainted");
                continue;
            }
            System.out.println(currentHeroes[i].getName() + "! It is your turn");
            publicHero = currentHeroes[i];
            currentHeroes[i].printHero(Colors.heroColors[i]);
            System.out.println("Would you like to basic attack or use something from your inventory? A for attack, I for inventory" );
            String attackOrIn = Input.getLetter();
            while (!attackOrIn.equals("A") && !attackOrIn.equals("I")){
                System.out.println("Sorry invalid input, please try again");
                attackOrIn = Input.getLetter();
            }
            if (attackOrIn.equals("A")){
                basicAttack(currentHeroes[i]);
            }
            else if (attackOrIn.equals("I")){
                currentHeroes[i].printItems(Colors.heroColors[i]);
                System.out.println("Which item would you like to use?");
                int userInput = Input.getInt();
                while(userInput < 0 || userInput >= currentHeroes[i].items.getSize()){
                    System.out.println("Please enter a valid input");
                    userInput = Input.getInt();
                }
                currentHeroes[i].getItem(userInput).useItem(currentHeroes[i]);

            }
            //checks to see if any monsters have 0, or below 0 hp, updates accordingly
            checkMonstersHP();

            if (monsters.size() == 0){
                //heroes win, updates heroes accordingly
                System.out.println("Congrats you have been victorious");
                for(int j = 0; j < currentHeroes.length; j++){
                    if (!currentHeroes[j].getFainted()){
                        currentHeroes[j].increaseXP(this.numberMonstersInit * 2);
                        currentHeroes[j].increaseGold(this.monsterLevel * 100);
                        currentHeroes[j].increaseHpAfterFight();
                        currentHeroes[j].increaseMpAfterFight();
                        currentHeroes[j].checkForLevelUp();
                        currentHeroes[j].reequipItems();
                    }
                    else{
                        currentHeroes[j].fainted = false;
                        currentHeroes[j].hp = currentHeroes[j].getLevel() * 100;
                        currentHeroes[j].reequipItems();
                    }
                }
                return true;
            }

        }
        //monsters attack after all heroes make one move
        monstersAttack();


    }
    return false;
    }
    //individual monster attack

    public void monsterAttack(int heroIndex, int monsterIndex){
        System.out.println(monsters.get(monsterIndex).name + " has attacked " + currentHeroes[heroIndex].getName());
        currentHeroes[heroIndex].takeDamage(monsters.get(monsterIndex).damage);
        if(currentHeroes[heroIndex].hp <0){
            currentHeroes[heroIndex].setHeroFainted();
            System.out.println("Hero " + currentHeroes[heroIndex].getName() + " has fainted!");
        }
        else{
            currentHeroes[heroIndex].printHero(Colors.heroColors[heroIndex]);
        }
        System.out.println(Colors.ANSI_RESET);
    }
    //function that simulates all monsters attacking
    public void monstersAttack(){
        for (int i = 0; i < monsters.size(); i++){
            System.out.println(Colors.heroColors[i]);
            if(!currentHeroes[0].getFainted()){
                monsterAttack(0, i);
                if (checkFaintedHeroes()){
                    return;
                }
            }
            else if(!currentHeroes[1].getFainted()){
                monsterAttack(1,i);
                if (checkFaintedHeroes()){
                    return;
                }
            }
            else if(!currentHeroes[2].getFainted()){
                monsterAttack(2,i);
                if (checkFaintedHeroes()){
                    return;
                }
            }
            else if(!currentHeroes[3].getFainted()){
                monsterAttack(3,i);
                if (checkFaintedHeroes()){
                    return;
                }
            }
        }
    }
    //prints monsters that are still alive

    public static void printMonsters (){
        String [][] printArray= new String[monsters.size()+1][6];
        printArray[0] = monsters.get(0).getMonsterLabel();

        for (int i = 0; i< monsters.size(); i++){

            printArray[i+1] = monsters.get(i).getMonsterDescription();
        }

        PrintArrays.printArray(printArray, Colors.ANSI_RESET, 0);
    }

    //applies spell to a monster
    public static void applySpell(Spell spellUse){
        System.out.println("Who do you want to apply this spell to?");
        printMonsters();
        int userInput = Input.getInt();
        while(userInput < 0 || userInput >= monsters.size()){
            System.out.println("Please enter a valid input");
            userInput = Input.getInt();
        }
        spellUse.spellEffect(monsters.get(userInput));
        monsters.get(userInput).takeGuarenteedDamage(spellUse.damageValue + (spellUse.damageValue * (publicHero.dexterity/10000)));
        monsters.get(userInput).printMonster();

    }

    //checks to see if any monsters have died
    public void checkMonstersHP(){
        for (int i = 0; i< monsters.size(); i++){
            if(monsters.get(i).getHP() <= 0){
                System.out.println(monsters.get(i).name + " has been slain!");
                monsters.remove(i);
                updateArrayMonsters();
            }
        }
    }
    //basic attack that the hero can use on any monster
    public void basicAttack(Hero currentHero){
        System.out.println("Who do you want to attack?");
        printMonsters();
        int userInput = Input.getInt();
        while(userInput < 0 || userInput >= monsters.size()){
            System.out.println("Please enter a valid input");
            userInput = Input.getInt();
        }
        monsters.get(userInput).takeDamage(currentHero.calcDamage());

        updateArrayMonsters();
        monsters.get(userInput).printMonster();

    }


}
