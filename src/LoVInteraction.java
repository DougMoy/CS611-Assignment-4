import java.util.ArrayList;
import java.util.List;
/*
 * LoVInteraction.java
 * by Douglas Moy, Mark Yang
 * CS611 Assignment 4
 *
 * A LoVInteraction is a subclass extending Interaction
 * The LoVInteraction class is responsible for executing combat when then a player chooses to attack or cast a spell.
 */
public class LoVInteraction extends Interaction{
    public LoVInteraction(){
        super(null);
    }

    public static boolean hasMonsterNearby(LegendsOfValorBoard board,
                                           Hero[] heroes, List<Monster> monsters, int heroIndex, int range){
        return monstersNearby(board, heroes, monsters, heroIndex, range).size() > 0;
    }

    private static List<Integer> monstersNearby(LegendsOfValorBoard board, Hero[] heroes,
                                        List<Monster> monsters, int heroIndex, int range) {
        assert range >= 0;
        if (range == 0) return new ArrayList<>();

        Hero hero = heroes[heroIndex];
        int x = board.playerXs[heroIndex];
        int y = board.playerYs[heroIndex];

        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < monsters.size(); i++){
            int tx = board.monsterXs.get(i);
            int ty = board.monsterYs.get(i);
            if (x - range <= tx && tx <= x + range && y - range <= ty && ty <= y + range) {
                out.add(i);
            }
        }

        return out;
    }
    private static List<Integer> heroesNearby(LegendsOfValorBoard board, Hero[] heroes,
                                                List<Monster> monsters, int monsterIndex, int range) {
        assert range >= 0;
        if (range == 0) return new ArrayList<>();

        Monster monster = monsters.get(monsterIndex);
        int x = board.monsterXs.get(monsterIndex);
        int y = board.monsterYs.get(monsterIndex);

        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < heroes.length; i++){
            int tx = board.playerXs[i];
            int ty = board.playerYs[i];
            if (x - range <= tx && tx <= x + range && y - range <= ty && ty <= y + range) {
                out.add(i);
            }
        }

        return out;
    }

    public static boolean hasHeroNearby(LegendsOfValorBoard board,
                                           Hero[] heroes, List<Monster> monsters, int monsterIndex, int range){
        return heroesNearby(board, heroes, monsters, monsterIndex, range).size() > 0;
    }

    public static void monsterAttack(List<Monster> monsters, Hero[] heroes, int monster, int hero){
        Monster m = monsters.get(monster);
        Hero h = heroes[hero];

        System.out.println(m.name + " has attacked " + h.getName());
        h.takeDamage(m.damage);
        if(h.hp <= 0){
            h.setHeroFainted();
            System.out.println("Hero " + h.getName() + " has fainted!");
        }
        else{
            h.printHero(Colors.heroColors[hero]);
        }
        System.out.println(Colors.ANSI_RESET);
    }

    public static void updateStats(Hero h, Tile t){
        if (t instanceof Bush) {
            h.updateDex(10);
        }
        else if (t instanceof Cave) {
            h.updateAgility(10);
        }
        else if (t instanceof Koulou) {
            h.updateStrength(10);
        }
    }

    public static void heroAttacks(LegendsOfValorBoard board, Hero[] heroes, List<Monster> monsters, int heroIndex){
        Hero hero = heroes[heroIndex];
        int x = board.playerXs[heroIndex];
        int y = board.playerYs[heroIndex];
        List<Integer> nearby = monstersNearby(board, heroes, monsters, heroIndex, 1);
        assert nearby.size() > 0;

        System.out.println("Select a target:");
        for (int i = 0; i < nearby.size(); i++){
            int monster = nearby.get(i);
            System.out.print("[" + i + "] at (" + board.monsterXs.get(monster) + "," + board.monsterYs.get(monster) + "): ");
            monsters.get(monster).printMonster();
        }
        int t = Input.pickInt(0, nearby.size() - 1);
        Monster target = monsters.get(t);

        monsters.set(t,heroBasicAttack(hero, target));
    }

    public static void heroCastsSpell(LegendsOfValorBoard board, Hero[] heroes, List<Monster> monsters, int heroIndex){
        Hero hero = heroes[heroIndex];
        int x = board.playerXs[heroIndex];
        int y = board.playerYs[heroIndex];

        List<Spell> spells = getSpells(hero);
        if (spells.size() == 0) {
            System.out.println("As you go to cast a spell, you realize there's no " +
                    "spell to be cast (No spells or low mana)!");
            System.out.println("...You spend the turn befuddled. Maybe next time check your (I)nformation?");
            return;
        }
        System.out.println("Select a spell:");
        for (int i = 0; i < spells.size(); i++) {
            Spell spell = spells.get(i);
            System.out.println("[" + i + "] " + spell.name + " (" + spell.manaCost + " Mana)");
        }
        Spell spell = spells.get(Input.pickInt(0, spells.size() - 1));


        List<Integer> nearby = monstersNearby(board, heroes, monsters, heroIndex, 2);
        assert nearby.size() > 0;

        System.out.println("Select a target:");
        for (int i = 0; i < nearby.size(); i++){
            int monster = nearby.get(i);
            System.out.print("[" + i + "] at (" + board.monsterXs.get(monster) + "," + board.monsterYs.get(monster) + "): ");
            monsters.get(monster).printMonster();
        }
        int t = Input.pickInt(0, nearby.size() - 1);
        Monster target = monsters.get(t);

        monsters.set(t,applySpell(hero, target, spell));
    }

    private static List<Spell> getSpells(Hero h){
        List<Spell> out = new ArrayList<>();
        for (Item item : h.items.getItems()) {
            if (item instanceof Spell) {
                Spell s = (Spell) item;
                if (h.getMana() >= s.manaCost) {
                    out.add(s);
                }
            }
        }
        return out;
    }

    private static Monster heroBasicAttack(Hero h, Monster m){
        m.takeDamage(h.calcDamage());
        m.printMonster();
        return m;
    }

    private static Monster applySpell(Hero h, Monster m, Spell s){
        s.spellEffect(m);
        m.takeGuarenteedDamage(s.damageValue + (s.damageValue * (h.dexterity/10000)));
        m.printMonster();
        return m;
    }

    public static void spawnMonsters(LegendsOfValorBoard gameBoard, Hero[] heroes, List<Monster> monsters, int level) {
        for (int lane = 0; lane < 3; lane++){
            if (gameBoard.isEmpty(0,0 + 3*lane)) {
                Monster x = MonsterGenerator.generateIndividualMonster(level);
                monsters.add(x);
                gameBoard.monsterXs.add(0 + 3*lane);
                gameBoard.monsterYs.add(0);
            }
            else if (gameBoard.isEmpty(0,1 + 3*lane)) {
                Monster x = MonsterGenerator.generateIndividualMonster(level);
                monsters.add(x);
                gameBoard.monsterXs.add(1 + 3*lane);
                gameBoard.monsterYs.add(0);
            }
        }
    }

    public static void takeMonsterTurn(LegendsOfValorBoard gameBoard, Hero[] heroes,
                                       List<Monster> monsters, int monster) {
        if (hasHeroNearby(gameBoard, heroes, monsters, monster, 1)) {
            //attack
            int target = 0;
            // randomize here if desired
            // target = randomChoice....
            monsterAttack(monsters, heroes, monster, target);
        }
        else {
            //move forward if possible
            int x = gameBoard.monsterXs.get(monster);
            int y = gameBoard.monsterYs.get(monster);
            if(gameBoard.isEmpty(x,y+1)){
                gameBoard.monsterXs.set(monster, x);
                gameBoard.monsterYs.set(monster, y + 1);
            }
        }
    }

    //recalls, ressurects, and heals any fainted heroes
    public static void ressurect(LegendsOfValorBoard gameBoard, Hero[] heroes, List<Monster> monsters) {
        for (int i = 0; i < heroes.length; i++) {
            Hero h = heroes[i];
            if (h.fainted){
                if (gameBoard.recall(i)) {
                    h.heroRes();
                    for (int j = 0; j < 5; j++) {
                        h.increaseHpAfterFight();
                        h.increaseMpAfterFight();
                    }
                }
            }
        }
    }

    public static void removeDeadMonster(LegendsOfValorBoard gameBoard, Hero[] heroes, List<Monster> monsters) {
        for (int i = 0; i < monsters.size(); i++) {
            Monster m = monsters.get(i);
            if (m.getHP() <= 0) {
                monsters.remove(i);
                gameBoard.monsterXs.remove(i);
                gameBoard.monsterYs.remove(i);
                i--;
            }
        }
    }
}
