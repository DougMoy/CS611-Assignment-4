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

## Notes
---------------------------------------------------------------------------
1. This program relies on ANSI escape characters to add background
    and foreground color. If your terminal does not support this, the game
    will look misaligned.
2. This project makes changes to many of the mechanics of the game.
    Please read the readme fully to get an idea of what has changed.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "pa1" after unzipping the files
2. Run the following instructions:
<Example below>
javac -d bin src/*.java
java -cp bin Main

## Changes to Original Project
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