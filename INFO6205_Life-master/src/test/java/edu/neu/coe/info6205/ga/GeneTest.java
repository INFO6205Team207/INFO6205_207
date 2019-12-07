package edu.neu.coe.info6205.ga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneTest {



    @Test
    public void getNum() {
        Gene gene = new Gene();
        boolean[] g = new boolean[]{true,true,true,true};
        gene.setGene(g);
        int num = gene.getNum();
        assertEquals(num, -1);
        boolean[] g1 = new boolean[]{true,false,false,true};
        gene.setGene(g1);
        int num2 = gene.getNum();
        assertEquals(num2, -7);
    }

    @Test
    public void mutation() {
        Gene gene = new Gene();
        boolean[] b1 = gene.getGene();
        gene.mutation();
        boolean[] b2 = gene.getGene();
        for(int i = 0; i < b1.length; i++){
            if(b1[i] != b2[2]) {
                assertTrue(b1[i] || b2[i]);
            }
        }

    }


}