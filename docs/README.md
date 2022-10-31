
# LPOO_18 - Snake

##   Description
This is a game similar to the classic Snake with some upgrades to make the game more challenging.
The objective of the game is to get the highest score possible by catching the apples that appears on the screen. For every apple caught the size of the snake is increased by one and its speed is slightly increased. There are still bonuses (worth level*2 score) appearing randomly in the map with limit duration. The player loses when the snake collides with walls or with its own body.
This project was developed by _Carlos Lousada_ (up201806302@fe.up.pt) and _Pedro Queirós_ (up201806329@fe.up.pt) for LPOO 19/20.

![New Issue · FEUP-LPOO_lpoo-2020-g18 (13)](https://user-images.githubusercontent.com/61288593/83360104-9df88600-a376-11ea-8a30-4bce24da9662.gif)

## Implemented Features
- **Menus** - There are several in the game.
	- ***Main Menu*** - In this menu the player has the option to play or exit the game.
	![Animated GIF-downsized_large](https://user-images.githubusercontent.com/61288593/83355964-b2c72080-a35a-11ea-901e-b9dad9eb4332.gif)

	- ***Level Select Menu*** - In this menu the player can choose which level he wants to play or return to the Main Menu.
	![Animated GIF-downsized_large (1)](https://user-images.githubusercontent.com/61288593/83355358-fd469e00-a356-11ea-9379-e5276bf7f8ce.gif)
	- ***Pause Menu*** - If the player presses "P" while playing the game is paused and the Pause Menu is shown. In this menu the player can continue playing or return to the Main Menu. 	![Animated GIF-downsized_large (1)](https://user-images.githubusercontent.com/61288593/83356014-16514e00-a35b-11ea-9d43-9f44bce12f1a.gif)
	- ***Game Over Menu*** - This menu appears when the player loses, showing the final score. Pressing "Enter" returns to the Main Menu.

		![Animated GIF-downsized_large (2)](https://user-images.githubusercontent.com/61288593/83356063-5b758000-a35b-11ea-88a2-e68ffac8bdf8.gif)

- **Snake movement** -  The snake can move in four directions: right (right arrow), left (left arrow), up (up arrow) and down (down arrow). It continues its movement in the selected direction until another key is pressed.
![Animated GIF-downsized_large (3)](https://user-images.githubusercontent.com/61288593/83356088-9972a400-a35b-11ea-8db6-0c05475779ab.gif)
- **Apple catching** - The snake can catch apples that appear on the map. There is only one apple on screen at a time. 
![Animated GIF-downsized_large (4)](https://user-images.githubusercontent.com/61288593/83356140-ddfe3f80-a35b-11ea-95be-ae2bc963aa38.gif)
- **Bonus catching** - The snake can catch bonuses that randomly appear on the map. There is only one bonus on screen at a time and it disappears after a short duration.

	![Animated GIF-downsized_large (5)](https://user-images.githubusercontent.com/61288593/83356206-5e24a500-a35c-11ea-8206-f96d33142881.gif)
- **Snake growing** - Upon catching an apple or a bonus, the snake will grow one unit.
![Animated GIF-downsized_large (12)](https://user-images.githubusercontent.com/61288593/83360725-7952dd00-a37b-11ea-84a6-4e7640dc1656.gif)
- **Different Levels** - There are three different levels in the game with increasing difficulty. Level 1 has an arena with teleports and no walls. Level 2 has an arena with walls around it and teleports in specific places. Level 3 has an arena with walls around it, in the middle and has no teleports.
	- ***Level 1***

	![Animated GIF-downsized_large (6)](https://user-images.githubusercontent.com/61288593/83356271-f9b61580-a35c-11ea-89d8-467cc2330664.gif)
	- ***Level 2***

	![Animated GIF-downsized_large (7)](https://user-images.githubusercontent.com/61288593/83356308-43066500-a35d-11ea-9bcc-383f142fcfdd.gif)
	- ***Level 3***

	![Animated GIF-downsized_large (8)](https://user-images.githubusercontent.com/61288593/83356349-94165900-a35d-11ea-8c69-74c317b393f5.gif)
- **Teleports** - In level 1 and 2, when the snake hits the edge of the screen it teleports to the opposite edge.   
	- ***Level 1***

	![Animated GIF-downsized_large (9)](https://user-images.githubusercontent.com/61288593/83356566-e99f3580-a35e-11ea-89ba-37b18fd5646e.gif)
	- ***Level 2***

	![Animated GIF-downsized_large (10)](https://user-images.githubusercontent.com/61288593/83356739-f07a7800-a35f-11ea-832d-fa30a1f544f6.gif)

- **Score and game time** - The player's current score and game time is shown on the bottom of the screen.
![Animated GIF-downsized_large (11)](https://user-images.githubusercontent.com/61288593/83360243-c03ed380-a377-11ea-981c-3fb270713596.gif)
## Design
There will be different states in the game.
### Problem in Context
While the program is running, there will be different states depending if the player is on main menu, selecting the level, pause menu, playing the game or in game over menu. There should be something that indicates the game state.

### The Pattern
We will apply the **State** pattern. Each state of the game will be implemented in different classes that implement an interface. Depending on the game's current state, the controller classes should implement different actions.
### Implementation
 ![Blank Diagram](https://user-images.githubusercontent.com/61288593/83359606-34c34380-a373-11ea-80f5-c967d19fe786.jpeg)

### Consequences
- By applying this pattern every state becomes more explicit, instead of relying on flags that indicate the current state.
- The code becomes cleaner because there is no need to have if statements according to the game state.
- A new game state can be added just by creating a new class.

## Architectural  
This project implements the MVC architectural pattern. With this pattern the project has three components: the **Model**, the **View** and the **Controller**. In the Model we have all the data of the program. The functions responsible for what the player can see are included in the View. The Controller allows for the interaction between the player and the game. So we have the following packages: model, view and control.

[![](https://mermaid.ink/img/eyJjb2RlIjoiZ3JhcGggVERcbiAgQVtDb250cm9sXSAtLT4gfHJlbmRlcnN8IEMoVmlldylcbiAgQ1tWaWV3XSAtLT4gfGFjdGlvbnN8IEEoQ29udHJvbClcbiAgQ1tWaWV3XSAtLT4gfGRpc3BsYXlzfCBCKE1vZGVsKVxuICBBW0NvbnRyb2xdIC0tPnxtYW5pcHVsYXRlc3wgQihNb2RlbClcblxuXG5cdFx0IiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZ3JhcGggVERcbiAgQVtDb250cm9sXSAtLT4gfHJlbmRlcnN8IEMoVmlldylcbiAgQ1tWaWV3XSAtLT4gfGFjdGlvbnN8IEEoQ29udHJvbClcbiAgQ1tWaWV3XSAtLT4gfGRpc3BsYXlzfCBCKE1vZGVsKVxuICBBW0NvbnRyb2xdIC0tPnxtYW5pcHVsYXRlc3wgQihNb2RlbClcblxuXG5cdFx0IiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)     

## Known code smells and refactoring suggestions
### Switch/If statements
The run() method in the **Arena Control Class** has a sequence of several if statements. That is a problem because it makes the code harder to read and if we need to add or modify something we will need to find this part of the code and modify it.
We could not find a way to resolve this code smell because we felt it was necessary to process the key pressed. 

### Long Method
In the **ArenaView Class** the draw() method is long. That makes the method hard to read and modify because it's doing a lot of things.
A way to improve the code would be to use the **Extract Method** to create new methods to simplify the code. This way the draw() method class would be shorter because it would only need to call the draw methods of the elements displayed on the screen.

### Duplicate Code
We have some duplicate code on the draw() methods of the following classes: **PauseMenuView**, **MainMenuView**, **LevelSelectView** and **GameOverView**. That makes the code harder to read and understand.
A way to improve the code would be to use the **Extract Method** to create a new method to be used by all of those classes.

## Testing
![image](https://user-images.githubusercontent.com/61288593/83359802-786a7d00-a374-11ea-9d4e-1593799e2b0e.png)


### Link to mutation testing report
[https://github.com/FEUP-LPOO/lpoo-2020-g18/blob/master/docs/tests/index.html](https://github.com/FEUP-LPOO/lpoo-2020-g18/blob/master/docs/tests/index.html)

## Self-Evaluation
- Carlos Lousada: 40%
- Pedro Queirós: 60%