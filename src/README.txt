# CS611-4
## Legends of Valor
---------------------------------------------------------------------------
Douglas Moy
dougmoy@bu.edu
U71000048

Mark Yang
mdyang@bu.edu
U27016194

## Files
---------------------------------------------------------------------------
README.txt                  - You are here
*.java                      - Java class files
*.txt                       - Resource files of various information and stats

<A brief description of each file and what it does>
Armor.java represents the armor item class. It implements the useItem method from the parent item class
Board.java is an abstract board class that represents boards that can be traversed by users and has multiple different tiles. It has methods that does things that all board games of this type would do. For example, it has methods that move the player on the board, methods that print the board, methods that ensure valid moves, and methods that return the tile the player is currently on. Any Board game of this type where players roam around the world would use these.
Bush.java extends tile class, represents a Bush. Calls enhanceHero function to appropriately boost the hero.
Cave.java extends tile class, represents a Cave. Calls enhanceHero function to appropriately boost the hero.
Colors.java houses all the color variables used in printing
CommonSpace.java extends tile class, represents a common space where battles can occur.
FightInteraction.java schedules the fights between monsters and heroes. Has functions that simulate combat
FireSpell.java extends spell which extends item. Represents a fireSpell in the game.
Game.java is an abstract class that houses methods that would be useful in games like this such as interacting with markets or fighting monsters.
GameChooser.java is a class that houses the function that allows us to choose between Monsters and Heroes and Legends of valor
GameStart.java is a class that houses functions that prompts users for inputs for the initialization of the game and then initializes an instance of the game.
GenerateRandom.java is a class used to select random rows from 2d String arrays. Useful for selecting random monsters and random items when initializing things.
Hero.java is an abstract class that represents a hero in the game. Has all the functions needed to modify the hero accordingly. Paladin, Warrior and Sorcerer all extend.
HeroNexus.java extends the Market class, is a nexus. Different marker and market item initialization.
IceSpell.java extends spell which extends item. Represents a iceSpell in the game.
Input.java houses functions that get user input from the user. IE selecting heroes, selecting numbers.
Interaction.java is abstract interaction class. Used for interactions with one hero.
Item.java is an abstract item class. Represents an item in the game. Implements abstract useItem function that all items must implement.
Inventory.java houses a hero's inventory. Has functions that modify a user's inventory. Each object of this class is a respective hero's inventory.
Koulou.java implements abstract tile class. enhanceHero function properly modifies the hero.
LightningSpell.java extends spell which extends item. Represents a LightningSpell in the game
Main.java is portal to game.
LegendsOfValorBoard.java extends abstract Board class, is the board that the game is played on.
LoVGame.java houses game logic for the Legends of Valor game.
LoVInteraction.java houses logic and functions for a lot of interactions in the game.
MAndHGame.java extends the game class, represents a more specific version of the game that is monsters and heroes. Game is run in here.
MarketInteraction.java extends interaction class, used to simulate market transactions.
MarketTile.java extends tile class, used to represent market on the board. Stores the items available at the market in this class
Monster.java is a class that represents all the monsters in the game. Since the monsters are all the same besides the base stats, I did not feel the need to make this class abstract
MonsterGenerator.java is a class that takes in all three files of monsters given and generates monsters to fight
MonstersAndHeroesBoard extends board class. Doesn’t implement any new methods, but has a unique init to account for tiles specific to the game
Paladin.java extends hero class. Represents paladin hero. Has unique level up function.
Potion.java extends item class. Represents a potion in the game. UseItem method simulates using a potion.
PrintArrays.java has methods that print and properly format 2d arrays.
ReadInFile.java has methods that read in text from files and forms 2d arrays that are used throughout the game.
Sorcerer.java extends hero class. Represents sorcerer hero. Has unique level up function.
Spell.java extends item class. Is an abstract class for the individual spells.
Tile.java is an abstract class that simulates the tiles on the board. Has functions used for printability and viewability.
Warrior.java extends hero class. Represents warrior hero. Has unique level up function.
Weapon.java extends item class. Represents weapons in the game. useItem function equips it.



## Notes
---------------------------------------------------------------------------
1. This program relies on ANSI escape characters to add background
    and foreground color. If your terminal does not support this, the game
    will look misaligned.
2. This project makes changes to many of the mechanics of the game.
    Please read the readme fully to get an idea of what has changed.

1. Navigate to the directory where all the .txt files and .java files are held
2. Run the following instructions:
javac *.java
java Main

## Bonuses for Original Project
---------------------------------------------------------------------------
1. Color coded
    Colored components have been added to the game
2. Spell range buff
    Spells can be cast on monsters 2 tiles away. This is to demonstrate the
    extensibility of the code, as well as add another layer of strategy to
    the game, as now inter-lane positioning is important to attack other
    lanes.
3. Row extension
    The number of rows of the board (i.e. the distance from one nexus to the other) can be changed or shortened.
4. Epic Visuals
    Title screen is very engaging and draws users in. Users will be surely hooked by the colors and graphics.
## Input/Output Example
---------------------------------------------------------------------------
1) Game select screen. Here, you can select whether to play Monsters and Heroes
or Legends of Valor game.

        Which game would you like to play?
        1. Monsters and Heroes
        2. Legends of Valor

Either enter "1" or "2" to play the respective game.

Monsters and Heroes will not be described in this readme as it is from the previous assignment.

2) Legends of Valor game initialization screen

        WELCOME TO LEGENDS OF VALOR
        Which hero would you like to pick?
        Here are the <Hero class>:
             Name                  mana                  strength              agility               dexterity             starting money        starting experience
        [0]  Parzival              300                   750                   650                   700                   2500                  7
        ...
        <List of every hero>

Before the LoV (Legends of Valor) game starts, the player needs to select their 3 heroes.
Entering the number listed on the left of each hero will select them.

        How many rows would you like your map to have?

After hero selection, the game will ask you for how many rows the map will have. The higher the number you answer,
the further away the hero and monster nexus will be. 8 rows will give a square board.

        Welcome to Legends of Valor
          +---+---+---+---+---+---+---+---+
        0 |-E-| E | + |-E-| E | + |-E-| E |
          +---+---+---+---+---+---+---+---+
        1 |   | B | + |   |   | + | B |   |
          +---+---+---+---+---+---+---+---+
        2 | K | C | + | C | C | + |   | C |
          +---+---+---+---+---+---+---+---+
        3 | C |   | + |   |   | + | B | K |
          +---+---+---+---+---+---+---+---+
        4 |   | C | + |   | C | + |   | C |
          +---+---+---+---+---+---+---+---+
        5 | K | C | + | B | B | + | B | C |
          +---+---+---+---+---+---+---+---+
        6 |   | K | + | K |   | + | B | C |
          +---+---+---+---+---+---+---+---+
        7 | H |*H*| + | H |*H*| + | H |*H*|
          +---+---+---+---+---+---+---+---+
            0   1   2   3   4   5   6   7
        Hero 1's turn: Garl_Glittergold
        Controls:
        F/f: attack (a monster within one space)
        G/g: cast a spell (to a monster within two spaces)
        W/w: move up
        A/a: move right
        S/s: move down
        D/d: move right
        I/i: show information
        R/r: recall
        T/t: teleport to another hero
        M/m: enter market (when on nexus tile)
        Q/q: to quit

The game will start. Heros are marked with *asterisks* and are color coded. Monsters appear as -dashes- and are colored
black. Each letter on a board corresponds with a tile type.
Unmarked are Plains.
H is hero nexus.
E is monster nexus.
B is Bush.
C is Cave.
K is Koulou.
Players will select one of the moves prompted by entering the respective letter.

3.) Two teleport examples:

Hero 1's turn: Sehanine_Moonbow
   Controls:
   F/f: attack (a monster within one space)
   G/g: cast a spell (to a monster within two spaces)
   W/w: move up
   A/a: move right
   S/s: move down
   D/d: move right
   I/i: show information
   R/r: recall
   T/t: teleport to another hero
   M/m: enter market (when on nexus tile)
   Q/q: to quit
   T <--- INPUT
   Which hero would you like to TP to?
   [1]
   [2]
   1 <--- INPUT
   Click A to teleport left to a player, S to teleport below a player, D to teleport right to a player, if a letter is not present the teleport is not valid
   [A]
   A <--- INPUT
     +---+---+---+---+---+---+---+---+
   0 |-E-| E | + |-E-| E | + |-E-| E |
     +---+---+---+---+---+---+---+---+
   1 |   | K | + | C | K | + | B |   |
     +---+---+---+---+---+---+---+---+
   2 | K |   | + | K | B | + | K | C |
     +---+---+---+---+---+---+---+---+
   3 | C | K | + | K |   | + |   |   |
     +---+---+---+---+---+---+---+---+
   4 | C | K | + | C | K | + |   | B |
     +---+---+---+---+---+---+---+---+
   5 | K | K | + |   | B | + |   | K |
     +---+---+---+---+---+---+---+---+
   6 | C | C | + |   | C | + | K |   |
     +---+---+---+---+---+---+---+---+
   7 | H | H | + |*H*|*H*| + | H |*H*|
     +---+---+---+---+---+---+---+---+
       0   1   2   3   4   5   6   7
   Hero 2's turn: Skoraeus_Stonebones
   Controls:
   F/f: attack (a monster within one space)
   G/g: cast a spell (to a monster within two spaces)
   W/w: move up
   A/a: move right
   S/s: move down
   D/d: move right
   I/i: show information
   R/r: recall
   T/t: teleport to another hero
   M/m: enter market (when on nexus tile)
   Q/q: to quit
   T <--- INPUT
   Which hero would you like to TP to?
   [0]
   [2]
   0 <--- INPUT
   Click A to teleport left to a player, S to teleport below a player, D to teleport right to a player, if a letter is not present the teleport is not valid
   A <--- INPUT
   No valid teleport locations
     +---+---+---+---+---+---+---+---+
   0 |-E-| E | + |-E-| E | + |-E-| E |
     +---+---+---+---+---+---+---+---+
   1 |   | K | + | C | K | + | B |   |
     +---+---+---+---+---+---+---+---+
   2 | K |   | + | K | B | + | K | C |
     +---+---+---+---+---+---+---+---+
   3 | C | K | + | K |   | + |   |   |
     +---+---+---+---+---+---+---+---+
   4 | C | K | + | C | K | + |   | B |
     +---+---+---+---+---+---+---+---+
   5 | K | K | + |   | B | + |   | K |
     +---+---+---+---+---+---+---+---+
   6 | C | C | + |   | C | + | K |   |
     +---+---+---+---+---+---+---+---+
   7 | H | H | + |*H*|*H*| + | H |*H*|
     +---+---+---+---+---+---+---+---+
       0   1   2   3   4   5   6   7

4.) Fight example

+---+---+---+---+---+---+---+---+
0 |-E-| E | + | E |-E-| + |-E-| E |
  +---+---+---+---+---+---+---+---+
1 | C | B | + | K |   | + |   |   |
  +---+---+---+---+---+---+---+---+
2 | B |   | + |   | K | + | K | B |
  +---+---+---+---+---+---+---+---+
3 |-K-|   | + |-B-| K | + |- -| K |
  +---+---+---+---+---+---+---+---+
4 |*B*| C | + |   |*B*| + |   |* *|
  +---+---+---+---+---+---+---+---+
5 | B | K | + | B | C | + |   |   |
  +---+---+---+---+---+---+---+---+
6 | B |   | + | C | K | + |   | C |
  +---+---+---+---+---+---+---+---+
7 | H | H | + | H | H | + | H | H |
  +---+---+---+---+---+---+---+---+
    0   1   2   3   4   5   6   7
Hero 2's turn: Skoraeus_Stonebones
Controls:
F/f: attack (a monster within one space)
G/g: cast a spell (to a monster within two spaces)
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
R/r: recall
T/t: teleport to another hero
M/m: enter market (when on nexus tile)
Q/q: to quit
F <--- INPUT
Select a target:
[0] at (3,3): Name: BigBad-Wolf HP:100 Level: 1 Damage: 150 Dodge Chance: 15
Number [0-0]:0 <--- INPUT
Casper takes 32 damage!
Name: Casper HP:68 Level: 1 Damage: 100 Dodge Chance: 50