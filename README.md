  
INFO6295 Final Project -- Genetic Algorithm & Game of Life
===================================  
***
## Team 207
#### Team Member：Yezhi Miao，Ran Zhou

===================================  

### Please Note
![](https://tva1.sinaimg.cn/large/006tNbRwgy1g9qc6udx52j30yc0u0dk4.jpg")
contributor myz1996 miaoyz both are Yezhi Miao's account, we just found that! 
***
## Description
We use **Genetic Algorithm** to generate local optimum for the starting pattern of Game of Life and make the game running forever. 
### Game of Life
Given an unlimited grid with cells, each cell has an initial state live or dead and they breed in next genernation. There are some rules for cells to survive. 

**Each “live” cell will die if it has fewer than two or more than three neighbors**

**Each “dead” cell will come alive if it has exactly three neighbors.**

We have a starting pattern for the game which contains live cells and their position in the grid, there two conditions when the game running: all cells dead and some cells lasting for unlimited genernations.

### Genetic Algorithm
We use Genetic Algorithm to improve the start pattern and make cells lasting. For an optimization problem, a certain number of starting pattern can be abstractly represented as chromosomes, allowing the population to evolve towards a better solution. Evolution happens from generation to generation. And we evaluate the fitness of the entire population in each generation and generate new life populations through natural selection and mutation. Finally, we find local optimum for the starting pattern and make the game's cells survivinng forever. 
***

## Problem to Solve
We used genetic algorithm to generate random starting pattern and find the local best solution, by using this starting pattern, the cells group can last for a long time even forever if we have enough time.

***
## How to Run Code
1. Run the class Driver under ga package.
2. In class Driver, change the gene size in the following code:

    `public Driver() { super(10);}`

   Change the value in super() to define the number of cells' coordinates in the start pattern. And the value must be even.
3. In class Gene, change the value of GENE_LENGTH in the following code:

    `public static final int GENE_LENGTH = 4;`
     
It can increase or decrease the range of generating gene.
        
***
## Result
After 500 iterations of Genetic Algorithm, we can find the local optimum of starting pattern, the one of code result show as below(it's an example):
        
        the worst fitness is:-5.0
        the average fitness is:-0.11
        the total fitness is:-11.0
        geneI:34	Starting pattern:1 2, 3 3, 3 2, 2 2, 2 0	y:158.0

In this case, the best starting pattern is 1 2, 3 3, 3 2, 2 2, 2 0, and the best cell coordinate locate at 34th polulation. And this starting pattern can make the cells group lives forever.
