package edu.neu.coe.info6205.ga;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GeneticAlgorithmTest {

    @Test
    public void testSelect(){
        GeneticAlgorithm ga = new GeneticAlgorithm(10) {
            @Override
            public String changeX(Chromosome c) {
                return null;
            }

            @Override
            public double calculateFitness(String phenotype) {
                return 0;
            }
        };
        ga.init();
        ga.setAverageScore(10);
        for(int i = 0; i < ga.getPopulation().size(); i++){
            if(i % 2 != 0) ga.getPopulation().get(i).setScore(5);
            else ga.getPopulation().get(i).setScore(15);
        }
        Chromosome c = ga.selectChromosome();
        assertEquals(c.getScore(), 15, 0);
    }
}