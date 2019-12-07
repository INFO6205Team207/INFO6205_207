package edu.neu.coe.info6205.ga;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ChromosomeTest {

    @Test
    public void testclone() {
        Chromosome chro = new Chromosome(10);
        Chromosome chro2 = Chromosome.clone(chro);
        for(int i = 0; i < chro.getGenotype().length; i++){
            assertEquals(chro.getGenotype()[i], chro2.getGenotype()[i]);
        }
    }

    @Test
    public void genetic() {
        Chromosome c1 = new Chromosome(10);
        Chromosome c2 = new Chromosome(10);
        Gene[] gene1 = c1.getGenotype();
        Gene[] gene2 = c2.getGenotype();
        List<Chromosome> list =  Chromosome.genetic(c1, c2);
        Gene[] gene1After = list.get(0).getGenotype();
        Gene[] gene2After = list.get(1).getGenotype();
        boolean[] b = new boolean[4];
        for(int i = 0; i < gene1.length; i++){
            if(gene1[i] != gene1After[i]){
                for(int j = 0; j < gene2.length;j++){
                  if(gene2[j] == gene1[i]) b = gene2[j].getGene();
                }
            }
        }
        assertNotNull(b);

    }



}