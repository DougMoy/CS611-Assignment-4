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
1. Spell range buff
    Spells can be cast on monsters 2 tiles away. This is to demonstrate the
    extensibility of the code, as well as add another layer of strategy to
    the game, as now inter-lane positioning is important to attack other
    lanes.


## Input/Output Example
---------------------------------------------------------------------------
