package edu.neu.coe.info6205.ga;

import edu.neu.coe.info6205.life.base.Game;

public class Driver extends GeneticAlgorithm {

    public static final int NUM = 1 << 10;

    public Driver() {
        super(10);
    }

    @Override
    public String changeX(Chromosome chromosome){
        return chromosome.getPhenotype();
    }

    @Override
    public double calculateFitness(String phenotype) {
        // TODO Auto-generated method stub
        Game game = new Game();
        Game.Behavior g = game.start(phenotype);
        double score = g.generation * g.growth;
        return score;
    }

    public static void main(String[] args) {
        Driver test = new Driver();
        test.caculte();


    }
}