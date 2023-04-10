import java.util.ArrayList;
import java.util.List;

public class LoVInteraction extends Interaction{
    public LoVInteraction(){
        super(null);
    }

    public static boolean hasMonsterNearby(LegendsOfValorBoard board,
                                           Hero[] heroes, List<Monster> monsters, int heroIndex){
        return monstersNearby(board, heroes, monsters, heroIndex).size() > 0;
    }

    private static List<Integer> monstersNearby(LegendsOfValorBoard board, Hero[] heroes,
                                        List<Monster> monsters, int heroIndex) {
        Hero hero = heroes[heroIndex];
        int x = board.playerXs[heroIndex];
        int y = board.playerYs[heroIndex];

        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < monsters.size(); i++){
            int tx = board.monsterXs.get(i);
            int ty = board.monsterYs.get(i);
            if (x - 1 <= tx && tx <= x+1 && y - 1 <= ty && ty <= y+1) {
                out.add(i);
            }
        }

        return out;
    }

    public static void heroAttacks(LegendsOfValorBoard board, Hero[] heroes, List<Monster> monsters, int heroIndex){
        Hero hero = heroes[heroIndex];
        int x = board.playerXs[heroIndex];
        int y = board.playerYs[heroIndex];
        List<Integer> nearby = monstersNearby(board, heroes, monsters, heroIndex);
        assert nearby.size() > 0;

        System.out.println("Select a target:");
        for (int i = 0; i < nearby.size(); i++){
            int monster = nearby.get(i);
            System.out.print("[" + i + "] at (" + board.monsterXs.get(monster) + "," + board.monsterYs.get(monster) + "): ");
            monsters.get(monster).printMonster();
        }
        int t = Input.pickInt(0, nearby.size() - 1);
        Monster target = monsters.get(t);

        heroBasicAttack(hero, target);
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


        List<Integer> nearby = monstersNearby(board, heroes, monsters, heroIndex);
        assert nearby.size() > 0;

        System.out.println("Select a target:");
        for (int i = 0; i < nearby.size(); i++){
            int monster = nearby.get(i);
            System.out.print("[" + i + "] at (" + board.monsterXs.get(monster) + "," + board.monsterYs.get(monster) + "): ");
            monsters.get(monster).printMonster();
        }
        Monster target = monsters.get(Input.pickInt(0, nearby.size() - 1));

        applySpell(hero, target, spell);
    }

    private static List<Spell> getSpells(Hero h){
        List<Spell> out = new ArrayList<>();
        for (Item item : h.items) {
            if (item instanceof Spell) {
                Spell s = (Spell) item;
                if (h.getMana() >= s.manaCost) {
                    out.add(s);
                }
            }
        }
        return out;
    }

    private static void heroBasicAttack(Hero h, Monster m){
        m.takeDamage(h.calcDamage());
        m.printMonster();
    }

    private static void applySpell(Hero h, Monster m, Spell s){
        s.spellEffect(m);
        m.takeGuarenteedDamage(s.damageValue + (s.damageValue * (h.dexterity/10000)));
        m.printMonster();

    }
}
