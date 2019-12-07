package edu.neu.coe.info6205.ga;


import java.util.ArrayList;
import java.util.List;

public abstract class GeneticAlgorithm {

    private List<Chromosome> population = new ArrayList<>();//种群
    private List<Chromosome> farPopulation = new ArrayList<>();
    private int popSize = 100;//size of population
    private int geneSize;//max size
    private int maxIterNum = 500;//max iteration num
    private double mutationRate = 0.01;//probbility of mutation
    private int maxMutationNum = 3;//max length of mutation

    private int generation = 0;//current generation of population

    private double bestScore;//best fitness
    private double worstScore;//worst fitness
    private double totalScore;//total fitness
    private double averageScore;//ave fitness

    private String x; //solution
    private double y;
    private int geneI;//generation of population which contains x
    private List<Chromosome> generation0 = new ArrayList<>();


    public GeneticAlgorithm(int geneSize) {
        this.geneSize = geneSize;
    }

    public void init() {
        population = new ArrayList<>();
        for (int i = 0; i < popSize; i++) {
            Chromosome chromosome = new Chromosome(geneSize);
            population.add(chromosome);
        }
        for(Chromosome c : population){
            generation0.add(c);
        }

        calculateScore();
    }

    private void calculateScore() {
        setChromosomeScore(population.get(0));
        bestScore = population.get(0).getScore();
        worstScore = population.get(0).getScore();
        totalScore = 0;
        for (Chromosome c : population) {
            setChromosomeScore(c);
            if (c.getScore() > bestScore) { //set up bestscore
                bestScore = c.getScore();
                if (y < bestScore) {
                    x = changeX(c);
                    y = bestScore;
                    geneI = generation;
                }
            }
            if (c.getScore() < worstScore) { //set up worst score
                worstScore = c.getScore();
            }
            totalScore += c.getScore();
        }
        averageScore = totalScore / popSize;
        //due to precision issues, set to best value gradually
        averageScore = averageScore > bestScore ? bestScore : averageScore;

    }

    //get score of each chromosome
    private void setChromosomeScore(Chromosome c) {
        if(c == null) return;
        if(c.ifDuplicate() == true) {
            c.setScore(0);
            return;
        }
        String s = changeX(c);
        double y = calculateFitness(s);
        c.setScore(y);
    }

    //get phenotype of chromosome
    public abstract String changeX(Chromosome c);


    public abstract double calculateFitness(String phenotype);


    public Chromosome selectChromosome(){
        double slice = Math.random() * totalScore;
        double sum = 0;
        for (Chromosome c : population) {
            sum += c.getScore();

            if (sum > slice && c.getScore() >= averageScore) {
                return c;
            }

        }
        return null;
    }

    private void generateagain(){
        farPopulation = new ArrayList<>();
        for (int j = 0; j < popSize; j++) {
            Chromosome c = new Chromosome(geneSize);
            farPopulation.add(c);
        }
    }

    //generate next population
    private void evolve() {
        List<Chromosome> childPopulation = new ArrayList<>();
        //generate another population
        generateagain();
        while (childPopulation.size() < 50) {
            double prob = Math.random();
            Chromosome p1, p2;
            if(prob > 0.4) {
                p1 = selectChromosome();
                p2 = selectChromosome();
            }else if(prob <= 0.4 && prob >= 0.2){
                p1 = selectChromosome();
                int num = new Double(Math.random() * 10).intValue();
                p2 = farPopulation.get(num);
            }else{
                int num = new Double(Math.random() * 10).intValue();
                int num2 = new Double(Math.random() * 10).intValue();
                p1 = farPopulation.get(num);
                p2 = farPopulation.get(num2);
            }

            List<Chromosome> children = Chromosome.genetic(p1, p2);
            if (children != null) {
                for (Chromosome c : children) {
                    childPopulation.add(c);
                }
            }
        }
        //replace the old population with new population
        List<Chromosome> t = population;
        population = childPopulation;
        t.clear();
        t = null;

        mutation();
        //calculatie new population 's fitness
        calculateScore();
    }


    private void mutation() {
            for (Chromosome chro : population) {
                chro.mutation();
            }
    }

    public void caculte() {
        //initilizing population
        generation = 0;
        init();
        while (generation < maxIterNum) {
            evolve();
            generation++;
            System.out.println("-----------------------------------------------------------------------------------------------"+generation);
        }
        print();
    }

    //print information of whole process
    private void print() {
        System.out.println("--------------------------------");
        //System.out.println("the generation is:" + generation);
        //System.out.println("the best y is:" + bestScore);
        System.out.println("the worst fitness is:" + worstScore);
        System.out.println("the average fitness is:" + averageScore);
        System.out.println("the total fitness is:" + totalScore);
        System.out.println("geneI:" + geneI + "\tStarting pattern:" + x + "\ty:" + y);
//        for(Chromosome c : generation0){
//            System.out.println(c.getPhenotype());
//        }
    }


    public void setPopulation(List<Chromosome> population) {
        this.population = population;
    }

    public void setPopSize(int popSize) {
        this.popSize = popSize;
    }

    public void setGeneSize(int geneSize) {
        this.geneSize = geneSize;
    }

    public void setMaxIterNum(int maxIterNum) {
        this.maxIterNum = maxIterNum;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public void setMaxMutationNum(int maxMutationNum) {
        this.maxMutationNum = maxMutationNum;
    }

    public double getBestScore() {
        return bestScore;
    }

    public double getWorstScore() {
        return worstScore;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public void setWorstScore(double worstScore) {
        this.worstScore = worstScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Chromosome> getPopulation() {
        return population;
    }

}

