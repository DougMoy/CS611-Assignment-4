# CS611-<Assignment Number 3>
## <Legends: Monsters and Heros>
---------------------------------------------------------------------------
<Douglas Moy>
<dougmoy@bu.edu>
<U71000048>
 
## Files
---------------------------------------------------------------------------
<A brief description of each file and what it does>
Armor.java represents the armor item class. It implements the useItem method from the parent item class
Board.java is an abstract board class that represents boards that can be traversed by users and has multiple different tiles. It has methods that does things that all board games of this type would do. For example, it has methods that move the player on the board, methods that print the board, methods that ensure valid moves, and methods that return the tile the player is currently on. Any Board game of this type where players roam around the world would use these.
Colors.java houses all the color variables used in printing
commonSpace.java extends tile class, represents a common space where battles can occur. 
fightInteraction.java schedules the fights between monsters and heroes. Has functions that simulate combat
fireSpell.java extends spell which extends item. Represents a fireSpell in the game.
game.java is an abstract class that houses methods that would be useful in games like this such as interacting with markets or fighting monsters.
gameStartMandH.java is a class that collects all the information needed to initialize a new game.
generateRandom.java is a class used to select random rows from 2d String arrays. Useful for selecting random monsters and random items when initializing things.
hero.java is an abstract class that represents a hero in the game. Has all the functions needed to modify the hero accordingly. Paladin, Warrior and Sorcerer all extend.
iceSpell.java extends spell which extends item. Represents a iceSpell in the game.
input.java houses functions that get user input from the user. IE selecting heroes, selecting numbers.
interaction.java is abstract interaction class. marketInteraction extends. Used for one hero interactions
item.java is an abstract item class. Represents an item in the game. Implements abstract useItem function that all items must implement.
lightningSpell.java extends spell which extends item. Represents a lightningSpell in the game
main.java is portal to game.
mAndHGame.java extends the game class, represents a more specific version of the game that is monsters and heroes. Game is run in here.
marketInteraction.java extends interaction class, used to simulate market transactions.
marketTile.java extends tile class, used to represent market on the board. Stores the items available at the market in this class
monster.java is a class that represents all the monsters in the game. Since the monsters are all the same besides the base stats, I did not feel the need to make this class abstract 
monsterGenerator.java is a class that takes in all three files of monsters given and generates monsters to fight
monstersAndHeroesBoard extends board class. Doesn’t implement any new methods, but has a unique init to account for tiles specific to the game
Paladin.java extends hero class. Represents paladin hero. Has unique level up function.
potion.java extends item class. Represents a potion in the game. UseItem method simulates using a potion.
printArrays.java has methods that print and properly format 2d arrays.
readInFile.java has methods that read in text from files and forms 2d arrays that are used throughout the game.
sorcerer.java extends hero class. Represents sorcerer hero. Has unique level up function.
spell.java extends item class. Is an abstract class for the individual spells.
tile.java is an abstract class that simulates the tiles on the board. Has functions used for printability and viewability.
warrior.java extends hero class. Represents warrior hero. Has unique level up function.
weapon.java extends item class. Represents weapons in the game. useItem function equips it.
## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in ConfigFiles, for parser class to
read class>
2. <Bonus Done>
Color, correctly formatted outputs such that they line up and are consistent. Can change the size of board. Checks for valid user inputs and asks them to reenter when they are wrong. 
3. <Notes to grader>
 
## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory where all the .txt files and .java files are held
2. Run the following instructions:
javac *.java 
java Main






 
## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>


INPUTS ARE ALWAYS ONE STRING OR NUMBER AFTER BEING PROMPTED. Heroes were incorrectly initialized on purpose to show how items can be bought.


How many heroes do you want to play on your team? Maximum: 4
1
Which hero would you like to pick?
Here are the paladins:




         Name                      mana                      strength                  agility                   dexterity                 starting money            starting experience   
[0]  Parzival                  300                       750                       650                       700                       2500                      7                         
[1]  Sehanine_Moonbow          300                       750                       700                       700                       2500                      7                         
[2]  Skoraeus_Stonebones   250                       650                       600                       350                       2500                      4                         
[3]  Garl_Glittergold          100                       600                       500                       400                       2500                      5                         
[4]  Amaryllis_Astra           500                       500                       500                       500                       2500                      5                         
[5]  Caliber_Heist             400                       400                       400                       400                       2500                      8                         
Here are the warriors:




         Name                      mana                      strength                  agility                   dexterity                 starting money            starting experience   
[6]  Gaerdal_Ironhand          100                       700                       500                       600                       1354                      7                         
[7]  Sehanine_Monnbow          600                       700                       800                       500                       2500                      8                         
[8]  Muamman_Duathall          300                       900                       500                       750                       2546                      6                         
[9]  Flandal_Steelskin         200                       750                       650                       700                       2500                      7                         
[10] Undefeated_Yoj            400                       800                       400                       700                       2500                      7                         
[11] Eunoia_Cyn                400                       700                       800                       600                       2500                      6                         
Here are the sorcerers:




         Name                      mana                      strength                  agility                   dexterity                 starting money            starting experience   
[12] Rillifane_Rallathil   1300                      750                       450                       500                       2500                      9                         
[13] Segojan_Earthcaller   900                       800                       500                       650                       2500                      5                         
[14] Reign_Havoc               800                       800                       800                       800                       2500                      8                         
[15] Reverie_Ashels            900                       800                       700                       400                       2500                      7                         
[16] Kalabar                   800                       850                       400                       600                       2500                      6                         
[17] Skye_Soar                 1000                      700                       400                       500                       2500                      5                         
Enter a number to select the corresponding hero:
0
Here are your heroes:
Parzival
How many rows would you like your map to have?
8
How many columns would you like your map to have?
8
Welcome to Monsters and Heroes!
+---+---+---+---+---+---+---+---+
| @ |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
| @ | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | @ | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
m
Who will enter the store? Enter -1 for all heroes to leave the store


[0] Parzival


0
Welcome to my store Parzival!
Would you like to buy or sell or leave? B/S/L
B
What would you like to buy? Enter -1 for the current hero to leave
Here is what I have:
KEY: Armor FireSpells Potions Weapons LightningSpells IceSpells Items the heroes have sold me




         Name                   cost                   required level         damage reduction   
[0]  Breastplate            350                    3                      600                    




         Name                 cost                 required level   damage               mana cost            
[1]  Breath_of_Fire   350                  1                    450                  100                  




         Name                     cost                     required level           attribute increase   attribute affected   
[2]  Luck_Elixir              500                      4                        65                       Agility                  




         Name                 cost                 level                damage               required hands   
[3]  Dagger               200                  1                    250                  1                    




         Name                   cost                   required level         damage                 mana cost              
[4]  Lightning_Dagger   400                    1                      500                    150                    




         Name                 cost                 required level   damage               mana cost            
[5]  Snow_Cannon          500                  2                    650                  250                  
3
You have successfully bought Dagger!
Would you like to buy or sell or leave? B/S/L
L
Who will enter the store? Enter -1 for all heroes to leave the store


[0] Parzival


-1
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | @ | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
i


Name: Parzival HP: 10000 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:




         Name         Cost         Level        Damage   Hands    
[0]  Dagger   200          1            250          1            






Enter Q/q to go back to the main menu
s
Invalid input, Enter Q/q to go back to the main menu
q
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | @ | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   | @ | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   | @ | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   | @ | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | @ |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
Your hero can not move here! Please select a different move
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | @ |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M | @ |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | @ |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   | @ |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   | @ |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   | @ |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | @ |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M | @ |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | @ |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| @ | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
Your hero can not move here! Please select a different move
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| @ | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
w
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
| @ |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
w
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
| @ |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
w
OH NO YOU HAVE BEEN ATTACKED!!!
Parzival! It is your turn


Name: Parzival HP: 10000 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:




         Name         Cost         Level        Damage   Hands    
[0]  Dagger   200          1            250          1            


Would you like to basic attack or use something from your inventory? A for attack, I for inventory
I




         Name         Cost         Level        Damage   Hands    
[0]  Dagger   200          1            250          1            


Which item would you like to use?
0
Successfully equipped item


Casper has attacked Parzival


Name: Parzival HP: 9900 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:




Parzival! It is your turn


Name: Parzival HP: 9900 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:


Would you like to basic attack or use something from your inventory? A for attack, I for inventory
A
Who do you want to attack?




         Name               HP                 Level              Damage             Defense            Dodge Chance   
[0]  Casper             100                1                  100                100                50                 
0
Name: Casper HP:50 Level: 1 Damage: 100 Dodge Chance: 50


Casper has attacked Parzival


Name: Parzival HP: 9800 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:




Parzival! It is your turn


Name: Parzival HP: 9800 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:


Would you like to basic attack or use something from your inventory? A for attack, I for inventory
A
Who do you want to attack?




         Name               HP                 Level              Damage             Defense            Dodge Chance   
[0]  Casper             100                1                  100                100                50                 
0
Name: Casper HP:0 Level: 1 Damage: 100 Dodge Chance: 50
Casper has been slain!
Congrats you have been victorious
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
| @ |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
I


Name: Parzival HP: 10780 Level: 1 XP: 9 Mana: 330 Strength: 750 Agility: 650 Dexterity: 700 Money: 900
Here is Parzival's inventory:




         Name         Cost         Level        Damage   Hands    
[0]  Dagger   200          1            250          1            






Enter Q/q to go back to the main menu
Q
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
| @ |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |How many heroes do you want to play on your team? Maximum: 4
1
Which hero would you like to pick?
Here are the paladins:




     Name                  mana                  strength              agility               dexterity             starting money        starting experience   
[0]  Parzival              300                   750                   650                   700                   2500                  7                     
[1]  Sehanine_Moonbow      300                   750                   700                   700                   2500                  7                     
[2]  Skoraeus_Stonebones   250                   650                   600                   350                   2500                  4                     
[3]  Garl_Glittergold      100                   600                   500                   400                   2500                  5                     
[4]  Amaryllis_Astra       500                   500                   500                   500                   2500                  5                     
[5]  Caliber_Heist         400                   400                   400                   400                   2500                  8                     
Here are the warriors:




     Name                  mana                  strength              agility               dexterity             starting money        starting experience   
[6]  Gaerdal_Ironhand      100                   700                   500                   600                   1354                  7                     
[7]  Sehanine_Monnbow      600                   700                   800                   500                   2500                  8                     
[8]  Muamman_Duathall      300                   900                   500                   750                   2546                  6                     
[9]  Flandal_Steelskin     200                   750                   650                   700                   2500                  7                     
[10] Undefeated_Yoj        400                   800                   400                   700                   2500                  7                     
[11] Eunoia_Cyn            400                   700                   800                   600                   2500                  6                     
Here are the sorcerers:




     Name                  mana                  strength              agility               dexterity             starting money        starting experience   
[12] Rillifane_Rallathil   1300                  750                   450                   500                   2500                  9                     
[13] Segojan_Earthcaller   900                   800                   500                   650                   2500                  5                     
[14] Reign_Havoc           800                   800                   800                   800                   2500                  8                     
[15] Reverie_Ashels        900                   800                   700                   400                   2500                  7                     
[16] Kalabar               800                   850                   400                   600                   2500                  6                     
[17] Skye_Soar             1000                  700                   400                   500                   2500                  5                     
Enter a number to select the corresponding hero:
0
Here are your heroes: 
Parzival
How many rows would you like your map to have?
8
How many columns would you like your map to have?
8
Welcome to Monsters and Heroes!
+---+---+---+---+---+---+---+---+
| @ |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
| @ | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | @ | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
m
Who will enter the store? Enter -1 for all heroes to leave the store


[0] Parzival


0
Welcome to my store Parzival!
Would you like to buy or sell or leave? B/S/L
B
What would you like to buy? Enter -1 for the current hero to leave
Here is what I have:
KEY: Armor FireSpells Potions Weapons LightningSpells IceSpells Items the heroes have sold me




     Name               cost               required level     damage reduction   
[0]  Breastplate        350                3                  600                




     Name             cost             required level   damage           mana cost        
[1]  Breath_of_Fire   350              1                450              100              




     Name                 cost                 required level       attribute increase   attribute affected   
[2]  Luck_Elixir          500                  4                    65                   Agility              




     Name             cost             level            damage           required hands   
[3]  Dagger           200              1                250              1                




     Name               cost               required level     damage             mana cost          
[4]  Lightning_Dagger   400                1                  500                150                




     Name             cost             required level   damage           mana cost        
[5]  Snow_Cannon      500              2                650              250              
3
You have successfully bought Dagger!
Would you like to buy or sell or leave? B/S/L
L
Who will enter the store? Enter -1 for all heroes to leave the store


[0] Parzival


-1
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | @ | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
i


Name: Parzival HP: 10000 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:




     Name     Cost     Level    Damage   Hands    
[0]  Dagger   200      1        250      1        






Enter Q/q to go back to the main menu
s
Invalid input, Enter Q/q to go back to the main menu
q
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | @ | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   | @ | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   | @ | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   | @ | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | @ |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
s
Your hero can not move here! Please select a different move
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | @ |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M | @ |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | @ |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   | @ |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
d
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   | @ |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   | @ |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | @ |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M | @ |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | @ |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| @ | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
a
Your hero can not move here! Please select a different move
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| @ | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
w
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
| @ |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
w
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
|   |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
| @ |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
w
OH NO YOU HAVE BEEN ATTACKED!!!
Parzival! It is your turn


Name: Parzival HP: 10000 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:




     Name     Cost     Level    Damage   Hands    
[0]  Dagger   200      1        250      1        


Would you like to basic attack or use something from your inventory? A for attack, I for inventory
I




     Name     Cost     Level    Damage   Hands    
[0]  Dagger   200      1        250      1        


Which item would you like to use?
0
Successfully equipped item


Casper has attacked Parzival


Name: Parzival HP: 9900 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:




Parzival! It is your turn


Name: Parzival HP: 9900 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:


Would you like to basic attack or use something from your inventory? A for attack, I for inventory
A
Who do you want to attack?




     Name           HP             Level          Damage         Defense        Dodge Chance   
[0]  Casper         100            1              100            100            50             
0
Name: Casper HP:50 Level: 1 Damage: 100 Dodge Chance: 50


Casper has attacked Parzival


Name: Parzival HP: 9800 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:




Parzival! It is your turn


Name: Parzival HP: 9800 Level: 1 XP: 7 Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Money: 800
Here is Parzival's inventory:


Would you like to basic attack or use something from your inventory? A for attack, I for inventory
A
Who do you want to attack?




     Name           HP             Level          Damage         Defense        Dodge Chance   
[0]  Casper         100            1              100            100            50             
0
Name: Casper HP:0 Level: 1 Damage: 100 Dodge Chance: 50
Casper has been slain!
Congrats you have been victorious
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
| @ |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
I


Name: Parzival HP: 10780 Level: 1 XP: 9 Mana: 330 Strength: 750 Agility: 650 Dexterity: 700 Money: 900
Here is Parzival's inventory:




     Name     Cost     Level    Damage   Hands    
[0]  Dagger   200      1        250      1        






Enter Q/q to go back to the main menu
Q
+---+---+---+---+---+---+---+---+
|   |   | M | M |   | M | M | + |
+---+---+---+---+---+---+---+---+
|   | M | M | M |   |   | + |   |
+---+---+---+---+---+---+---+---+
| @ |   | M | M |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | + |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | M |   | M | + | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
Q
Would you like to play again? Y/N
N
+---+---+---+---+---+---+---+---+
| M | M |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| + | + |   |   | + |   | M |   |
+---+---+---+---+---+---+---+---+
|   | + |   | M |   | M |   | M |
+---+---+---+---+---+---+---+---+
Controls:
W/w: move up
A/a: move right
S/s: move down
D/d: move right
I/i: show information
M/m: enter market (when on market tile)
Q
Would you like to play again? Y/N
N