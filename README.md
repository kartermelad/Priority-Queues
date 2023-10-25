# Project #2: Stardew Valley

* Author: Karter Melad
* Class: CS321 Section #001
* Semester: Fall 2023

## Overview

This project uses a Priority Queue to create a game with a priority
based task management system. The priority based management system 
uses a heap to hold the data.

## Reflection

While writing this project I actually had the most issues with the
Junit testing. It was something I had never used before and it took
some learning and research. I had to go back and fix the testing class
multiple times throughout the project. Something that worked well was
using my own created tester that was outside of the project
requirements. My self created tester helped me understand what methods
were and werent working. 

Another relevant issue I faced was the Task Generator. Once I understood
how the file was being used in the MyLifeInStardew.java it made a lot more
sense on creating the constructor and how the methods would be used.
This is the same for the Priority Queue class I wrote. Reading
the other project files helped me greatly in understanding how
to write these classes.

## Compiling and Using

The user should run:
java MyLifeInStardew <max-priority-level> <time-to-increment-priority> 
<total simulation-time in days> <task-generation-probability> [<seed>]

This will a priority based game similar to "Stardew Valley". The game gives
the user energy while the user hopes to not pass out or die due to
energy depletion. 

## Results 

Writing the MaxHeapTest to make sure the MaxHeap class works properly was
challenging. After figuring out how the Junit testing works I was able to
properly write and use the tests for my MaxHeap class.

## Sources used

https://www.geeksforgeeks.org/max-heap-in-java/
https://courses.csail.mit.edu/6.006/fall10/handouts/recitation10-8.pdf

