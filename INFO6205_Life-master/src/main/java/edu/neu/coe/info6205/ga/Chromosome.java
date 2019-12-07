package edu.neu.coe.info6205.ga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chromosome {
    public static final int numOfGene = 8;
    private Gene[] genotype;
    private String phenotype;
    private double score;

    public Chromosome(){

    }

    //constructor for initializing Gene[]
    public Chromosome(int size){
        initGeneNum(size);
        for(int i = 0; i < size; i++){
            Gene gene = new Gene();
            genotype[i] = gene;
        }

    }

    public void initGeneNum(int size){
        genotype = new Gene[size];
    }

    //clone gene
    public static Chromosome clone(final Chromosome c) {
        if (c == null || c.genotype == null) {
            return null;
        }
        Chromosome copy = new Chromosome();
        copy.initGeneNum(c.genotype.length);
        for (int i = 0; i < c.genotype.length; i++) {
            copy.genotype[i] = c.genotype[i];
        }
        return copy;
    }

    public static List<Chromosome> genetic(Chromosome p1, Chromosome p2) {
        //if one chromosome is null, they cannot generate next
        if (p1 == null || p2 == null) return null;
        //if chromosome's genotype is null, cannot
        if (p1.genotype == null || p2.genotype == null) return null;
        //if two chromosome dont have the same size, they cannot
        if (p1.genotype.length != p2.genotype.length) return null;

        //copy two chromosoem
        Chromosome c1 = clone(p1);
        Chromosome c2 = clone(p2);

        //generate randome location to exchange gene
        int size = c1.genotype.length;
        int a = ((int) (Math.random() * size)) % size;
        int b = ((int) (Math.random() * size)) % size;
        int min = a > b ? b : a;
        int max = a > b ? a : b;

        //change gene
        Gene temp = c1.genotype[a];
        c1.genotype[a] = c2.genotype[b];
        c2.genotype[b] = temp;

        List<Chromosome> res = new ArrayList<>();
        res.add(c1);
        res.add(c2);
        return res;
    }

    public void mutation(){
        for(Gene gene : genotype){
            gene.mutation();
        }
    }

    public String getPhenotype(){
        String s = genotype[0].getNum() + " "+ genotype[1].getNum() +", " + genotype[2].getNum() + " " +genotype[3].getNum() + ", " +
                 genotype[4].getNum() + " " + genotype[5].getNum() +", " + genotype[6].getNum() + " " + genotype[7].getNum() + ", " +
                 genotype[8].getNum() + " " + genotype[9].getNum() ;



        return s;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    //check if phenotype has duplicates
    public boolean ifDuplicate(){
        String a = String.valueOf(genotype[0].getNum() + genotype[1].getNum());
        String b = String.valueOf(genotype[2].getNum() + genotype[3].getNum());
        String c = String.valueOf(genotype[4].getNum() + genotype[5].getNum());
        String d = String.valueOf(genotype[6].getNum() + genotype[7].getNum());
        String e = String.valueOf(genotype[8].getNum() + genotype[9].getNum());
        if(a.equals(b) || a.equals(c) || a.equals(d) || b.equals(c) || b.equals(d) || c.equals(d)
          || a.equals(e) || b.equals(e) || c.equals(e) || d.equals(e)) return true;
        return false;

    }

    public Gene[] getGenotype() {
        return genotype;
    }
}

