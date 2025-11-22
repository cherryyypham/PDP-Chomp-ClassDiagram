# Chomp Game

A Java implementation of [Chomp Game](https://www.math.ucla.edu/~tom/Games/chomp.html) using a randomly assigned Class Diagram that contains guidance for the architecture implemented in this submission. You can find the mentioned Class Diagram and Architecture Guide [here](https://github.com/cherryyypham/src/main/resources/ClassDiagram-assigned.pdf).

## About Chomp

Chomp is a two-player strategy game played on a rectangular grid representing a chocolate bar. Players take turns selecting a square to "chomp." When a square is selected, that square and all squares to the right and above it are eaten. The bottom-left square is poisoned - the player forced to eat it loses the game.

**Game Rules:**
- Players alternate turns selecting available chocolate squares
- Selecting a square eats that square plus all squares to its right and above
- The bottom-left square (0,0) is the poison square
- The player who eats the poison square loses
- The other player wins

## Project Structure
```
📦 
└─ src
   └─ main
      └─ java
         ├─ Controller
         │  ├─ CHOMPGame.java
         │  └─ Game.java
         ├─ Driver.java
         ├─ Model
         │  ├─ Board.java
         │  ├─ Cell.java
         │  └─ Player.java
         └─ View
            ├─ Display.java
            ├─ Frame.java
            ├─ GamePanel.java
            └─ InfoPanel.java
```

## Running the Program

```bash
# Navigate to project directory
cd PDP-Chomp-ClassDiagram/src

# Compile all files
javac chomp/*.java chomp/model/*.java chomp/controller/*.java chomp/view/*.java

# Run the program
java chomp.Driver
```

### Configuration

Default game settings in `Driver.java`:
```java
new CHOMPGame(6, 8, "P1", "P2");
```

Parameters:
- `6` - Number of rows
- `8` - Number of columns
- `"P1"` - First player name
- `"P2"` - Second player name


## Implementation Notes

### Deviations from Architecture Notes

While the implementation follows the provided architecture closely, a couple practical adjustments were made:

1. **Game Loop logic:** I think it's so silly and cluttered to implement a game loop in an almost static, purely event-listener-based program such as Chomp. So although the game loop management section in the architecture mention a"loop", I don't think they mean an actual loop, but just performed the mentioned action, update with `repaint()` after every move being recorded with the actionListener. Everything else is followed and I think this is a very justified modification if it even is one.
2. **Redundant methods:** `start()` and `endGame()` are not of use. There were no clear description of them, nor that there were any fruitful task for them to accomplish after I have populated the other classes. Given that `isGameOver()` already exists and there is no need to enable/disable gameplay since the buttons are already disabled after click (plus there's no timer or moving/constantly repainting elements.)

5. **Reset feature:** Added as enhancement because I want to play my chomp game again and again without having to recompile.

## Challenges and Reflection

I think the biggest challenge was to hold back and not modify the application based on my vision of it. After a couple
 urges to do so while transferring the classes from the diagram to code, I have to constrain myself to only populate
 existing classes according to instruction before putting my critical thinking brain back to figure out the program's
 flow and edit to make it work in a way that best preserve the already populated code. That being said, I had to get rid
 of `start()` and `endGame()` in the Abstract Class `Game` since I could not think of any way to implement these that is
 not redundant for reasons as stated above. In addition, the `playTurn()` method in the template became vestigial since the model is driven by event handling rather than a traditional game loop, but it's still allowed to exist because it provides a neat way to decouple game logic from the already quite chunky `actionPerformed()` method. In the end, I did sacrilegiously add a `reset` functionality, but it can be beautifully searched using the "reset" keyword and removed from the rest of the program, and it makes me more happy with my Chomp D:

Additionally, I had to handle the coordinate system inversion. The architecture specified (0,0) as bottom-left for the
 poison square, but 2D arrays naturally use top-left as (0,0). I resolved this by maintaining standard array
 indexing internally while reversing the button population order during GUI construction. This preserved logical array
 operations while achieving the correct visual representation.

Another challenge I faced in implementing this design was managing the GUI refresh cycle due to my lack of familiarity
 with Java Swing. Initially, button colors and borders weren't rendering correctly across different operating systems until I added `setOpaque(true)` and played around with some other fill/border stuff to make it most resembled to the sample GUI.

## Credits

* Original Game Concept: [Chomp Game](https://www.math.ucla.edu/~tom/Games/chomp.html)
* Project Tree was generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)
* Architecture guide was generated by an anonymous classmate.
