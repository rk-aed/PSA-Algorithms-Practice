package driver;

import java.util.Random;

public class SimpleDemoGA10 {

    Population1 Population1 = new Population1();
    Individual1 fittest;
    Individual1 secondFittest;
    int generationCount = 0;

    //Selection
    void selection() {

        //Select the most fittest Individual1
        fittest = Population1.getFittest();

        //Select the second most fittest Individual1
        secondFittest = Population1.getSecondFittest();
    }

    //Crossover
    void crossover() {
        Random rn = new Random();

        //Select a random crossover point
        int crossOverPoint = rn.nextInt(Population1.Individual1s[0].geneLength);

        //Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            int temp = fittest.genes[i];
            fittest.genes[i] = secondFittest.genes[i];
            secondFittest.genes[i] = temp;

        }

    }

    //Mutation
    void mutation() {
        Random rn = new Random();

        //Select a random mutation point
        int mutationPoint = rn.nextInt(Population1.Individual1s[0].geneLength);

        //Flip values at the mutation point
        if (fittest.genes[mutationPoint] == 0) {
            fittest.genes[mutationPoint] = 1;
        } else {
            fittest.genes[mutationPoint] = 0;
        }

        mutationPoint = rn.nextInt(Population1.Individual1s[0].geneLength);

        if (secondFittest.genes[mutationPoint] == 0) {
            secondFittest.genes[mutationPoint] = 1;
        } else {
            secondFittest.genes[mutationPoint] = 0;
        }
    }

    //Get fittest offspring
    Individual1 getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }


    //Replace least fittest Individual1 from most fittest offspring
    void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit Individual1
        int leastFittestIndex = Population1.getLeastFittestIndex();

        //Replace least fittest Individual1 from most fittest offspring
        Population1.Individual1s[leastFittestIndex] = getFittestOffspring();
    }

}


//Individual1 class
class Individual1 {

    int fitness = 0;
    int[] genes = new int[10];
    int geneLength = 10;

    public Individual1() {
        Random rn = new Random();

        //Set genes randomly for each Individual1
        for (int i = 0; i < genes.length; i++) {
            genes[i] = Math.abs(rn.nextInt() % 2);
        }

        fitness = 0;
    }

    //Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < 10; i++) {
            if (genes[i] == 1) {
                ++fitness;
            }
        }
    }

}

//Population1 class
class Population1 {

    int popSize = 10;
    Individual1[] Individual1s = new Individual1[5];
    int fittest = 0;

    //Initialize Population1
    public void initializePopulation1(int size) {
        for (int i = 0; i < Individual1s.length; i++) {
            Individual1s[i] = new Individual1();
        }
    }

    //Get the fittest Individual1
    public Individual1 getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < Individual1s.length; i++) {
            if (maxFit <= Individual1s[i].fitness) {
                maxFit = Individual1s[i].fitness;
                maxFitIndex = i;
            }
        }
        fittest = Individual1s[maxFitIndex].fitness;
        return Individual1s[maxFitIndex];
    }

    //Get the second most fittest Individual1
    public Individual1 getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < Individual1s.length; i++) {
            if (Individual1s[i].fitness > Individual1s[maxFit1].fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (Individual1s[i].fitness > Individual1s[maxFit2].fitness) {
                maxFit2 = i;
            }
        }
        return Individual1s[maxFit2];
    }

    //Get index of least fittest Individual1
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < Individual1s.length; i++) {
            if (minFitVal >= Individual1s[i].fitness) {
                minFitVal = Individual1s[i].fitness;
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    //Calculate fitness of each Individual1
    public void calculateFitness() {

        for (int i = 0; i < Individual1s.length; i++) {
            Individual1s[i].calcFitness();
        }
        getFittest();
    }

}
