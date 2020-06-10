# CSX42: Assignment 1
## Name: Preeti Priyam

-----------------------------------------------------------------------
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when
compiled the code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
Justification for the Data Structures used in the assignment in terms of time and/or space complexity.

ArrayList is a dynamic size array which is better in terms of space and time complexity as we don't have to define a static size for the array. Moreover, when compare to other data structure such as LinkedList, Stack, Queue, etc., in terms of time complexity for inserting, reading a value, ArrayList is better.
Time complexity for inserting a new element in an ArrayList : O(1)
Time complexity for inserting a new element at a given index in an ArrayList : O(n)
Time complexity for removing an element by its value in an ArrayList : O(n)
Time complexity for removing an element at a given index in an ArrayList : O(1)
Time complexity for reading an element at a given index in an ArrayList : O(n)

Class Results and matrix calculator uses ArrayList.
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [06/10/2020]
