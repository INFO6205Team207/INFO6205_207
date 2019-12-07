package edu.neu.coe.info6205.ga;

import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void calculateFitness() {
        String s = "1 0, 0 1, 2 0";
        Driver d = new Driver();
        double fitness = d.calculateFitness(s);
        assertEquals(fitness, -3.0, 0);

        String s1 = "1 2, 2 1, 3 1, 4 2, 3 3, 2 3";
        fitness = d.calculateFitness(s1);
        assertEquals(fitness, 0, 0);
    }
}