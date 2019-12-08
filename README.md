  
INFO6295 Final Project -- Genetic Algorithm & Game of Life
===================================  
***
## Team 207
#### Team Member：Miao Yezhi，Zhou Ran

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
     
It can change the scope of each gene.

4. If you change the number of cells' coordinates in the step 1, you must motify the `getPhenotype()` in the class Chromosome:

        public String getPhenotype(){
        String s = genotype[0].getNum() + " "+ genotype[1].getNum() +", " + genotype[2].getNum() + " " 
        + genotype[3].getNum() + ", " + genotype[4].getNum() + " " + genotype[5].getNum() +", " 
        + genotype[6].getNum() + " " + genotype[7].getNum() + ", " + genotype[8].getNum() + " " 
        + genotype[9].getNum();
        return s;}
        
***
## Result
After 500 iterations of Genetic Algorithm, we can find the local optimum of starting pattern, the one of code result show as below(it's an example):
        
        the worst fitness is:-5.0
        the average fitness is:-1.51
        the total fitness is:-151.0
        geneI:279	Starting pattern:3 7, 5 7, 4 7, 7 7, 7 7	y:50.0

In this case, the best starting pattern is 3 7, 5 7, 4 7, 7 7, 7 7, and the best cell coordinate locate at 279th generation. And this starting pattern can make the cells group lives forever.
