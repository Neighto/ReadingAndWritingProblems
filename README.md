# Reading And Writing Problems
Solutions to three separate problems that involve reading from files and subsequently writing to a file. This was my submission for the final assignment in an Algorithms and Data Structures class. 

> All three solutions were written in Java using Eclipse. Made by Nathan Ladd.

## Balloons
Consider a room full of balloons and arrows will be shot from the left end of a room and fly straight to the right end of the room at a height H. If an arrow hits a balloon, the arrow will go down to a height of H-1 in the next position and the balloon will be popped. This height will be maintained until it reaches the wall or hits another balloon. The balloon.java file will read an input file of balloon positions and output a file that has the number of arrows necessary to pop all of the balloons.
The input file has an integer n on line 1 that is the number of 'cases' in the file. Line 2 contains n integers mi separated by a space, each representing the total number of balloons of the ith  problem. Line 3 onwards has mi integers hj separated by a space, that are the respective heights of the jth balloon from left to right.

## Mancala
Consider a variant of mancala where the player is given a board with 12 holes. Some of the holes will contain a rock. The player can move rocks if there is another rock adjacent to it, and if the further spot of the adjacent rock is empty. The rock will move to the empty spot and the adjacent rock will be removed from the game. The goal of the game is to find the pattern that eliminates the most rocks from the board. The mancala.java file will read an input file of rock positions on a board of size 12 and output a file that shows how many rocks remain after executing the best possible solution. The input file has an integer n on line 1 that is the number of 'cases' in the file. Each other line contains a problem with 12 integers representing the mancala board. A '0' represents no rock and a '1' represents a rock in that position.  

## Islands
Consider a 2D array of black and white pixels where the black pixels represent water and the white pixels represent land. The input file will represent black pixels as '#' and white pixels as '-'. The islands.java file will read the input file of 2D arrays and output a file that is the number of islands in the array, where islands are any land mass surrounded by water. The input file has an integer n on line 1 that is the number of 'cases' in the file. Each 'case' starts with a line with integer m and n that represent width and length of the array, respectively. The other lines are the array with '#' and '-' characters.
