package driver;

import java.util.Random;

public class DQuestionDriver {
	public static void main(String[] args) {
		
		Random rn = new Random();
		
		
        System.out.println("#####################");
        System.out.println(" Question 2 (D) with 10 genes ");
        
        
        SimpleDemoGA10 demo1 = new SimpleDemoGA10();

        //Initialize population
        demo1.Population1.initializePopulation1(6); 

        //Calculate fitness of each individual
        demo1.Population1.calculateFitness();

        System.out.println("Generation: " + demo1.generationCount + " Fittest: " + demo1.Population1.fittest);

        //While population gets an individual with maximum fitness
        while (demo1.Population1.fittest < 9) {
            ++demo1.generationCount;

            demo1.selection();

            demo1.crossover();

            
            if (rn.nextInt()%7 < 10) {
            	demo1.mutation();
            }

            demo1.addFittestOffspring();

            //Calculate new fitness value
            demo1.Population1.calculateFitness();

            System.out.println("Generation: " + demo1.generationCount + " Fittest: " + demo1.Population1.fittest);
        }

        System.out.println("\nSolution found in generation " + demo1.generationCount);
        System.out.println("Fitness: "+demo1.Population1.getFittest().fitness);
        System.out.print("Genes: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(demo1.Population1.getFittest().genes[i]);
        }

        System.out.println("");
                


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
