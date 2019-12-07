package edu.neu.coe.info6205.ga;

public class Gene {
    public static final int GENE_LENGTH = 3;
    private boolean[] gene;
    private double mutationRate = 0.01;



    //constructor for initializing the boolean[], totally random 0 OR 1
    public Gene(){
        gene = new boolean[GENE_LENGTH];
        init();
    }

    public void init(){
        for (int i = 0; i < GENE_LENGTH; i++) {
            gene[i] = Math.random() >= 0.5;
        }
    }

    //get int value of boolean[] gene
    public int getNum() {
        int num = 0;
        if (gene == null) {
            return 0;
        }
        if(!gene[0]){

            for (boolean bool : gene) {
                num <<= 1;
                if (bool) {
                    num += 1;
                }
            }

        }
        else {

            boolean[] ng_gene = new boolean[gene.length];
            for (int i = gene.length -1 ; i >= 0; i--) {
                if(!gene[i]){
                    gene[i] = true;
                }
                else{
                    gene[i] = false;
                    break;
                }
            }

            for (int i = 0; i<= gene.length-1; i++){
                ng_gene[i] =! gene[i];
            }
            for (boolean bool : ng_gene) {
                num <<= 1;
                if (bool) {
                    num += 1;
                }
            }
            num = num * (-1);
        }
        return num;

            }

    //if random figure < mutation Rate, 0 to 1 OR 1 to 0$
    public void mutation(){
        int size = gene.length;
        for (int i = 0; i < size; i++) {
            if (Math.random() < mutationRate) {
                boolean bool = !gene[i];
                gene[i] = bool;
            }
        }
    }

    public boolean[] getGene(){
        return gene;
    }

    public void setGene(boolean[] b){
        this.gene = b;
    }
}
