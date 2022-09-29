import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class runKnapsackTests {
    public static void main(String[] args) {
        knapsack_item list[] = new knapsack_item[250];
        for (int i = 0; i < 250; i++) {
            list[i] = new knapsack_item((int)(Math.random()*32)+1, (int)(Math.random()*16) + 1);
        }

        int b = 1000;

        int[] knapsack_values = new int[250];

        
        for (int i = 0; i < knapsack_values.length; i++) {
            knapsack_values[i] = list[i].getValue();
        }
        int[] knapsack_weights = new int[250];
        for (int i = 0; i < knapsack_weights.length; i++) {
            knapsack_weights[i] = list[i].getCost();
        }

        maximum_knapsack_prob1 testProb1 = new maximum_knapsack_prob1();
        amax_knapsack testProb2 = new amax_knapsack();
        Greedy_max_knapsack_prob3 testProb3 = new Greedy_max_knapsack_prob3();
        amax_knapsack testProb4 = new amax_knapsack();

        // double startTime = System.nanoTime();
        // //System.out.print(testProb1.RMK(b, knapsack_values, knapsack_weights));
        // //System.out.print(testProb2.solveMaxKnapsack(b, knapsack_weights, knapsack_values));
        // //System.out.print(testProb3.newGMK(list, b));
        // System.out.print(testProb4.useFPTAS(b, knapsack_values, knapsack_weights, 2));
        // double endTime = System.nanoTime();
        // System.out.print(",");
        // System.out.print((endTime - startTime)/1000000000);
        // System.out.println();
        
        // //testProb4.useFPTAS(b, knapsack_values, knapsack_weights, 2);

        // // System.out.println("Regular Maximum Knapsack: " + testProb1.RMK(b, knapsack_values, knapsack_weights));
        // // System.out.println("a_max knapsack (mincost): " + testProb2.solveMaxKnapsack(b, knapsack_weights, knapsack_values));
        // // System.out.println("Greedy Max Knapsack: " + testProb3.newGMK(list, b));
        // // System.out.println("FPTAS with scaling factor of 2: " + testProb4.useFPTAS(b, knapsack_values, knapsack_weights, 2));
        double RMKStartTime = System.nanoTime();
        int RMKResult = testProb1.RMK(b, knapsack_values, knapsack_weights);
        double RMKEndTime = System.nanoTime();

        double amaxStartTime = System.nanoTime();
        int amaxResult = testProb2.solveMaxKnapsack(b, knapsack_weights, knapsack_values);
        double amaxEndTime = System.nanoTime();

        double greedyStartTime = System.nanoTime();
        int greedyResult = testProb3.newGMK(list, b);
        double greedyEndTime = System.nanoTime();

        double FPTAS_startTime = System.nanoTime();
        double FPTAS_result = testProb4.useFPTAS(b, knapsack_values, knapsack_weights, 2);
        double FPTAS_endTime = System.nanoTime();

        //write results to csv file - put in arraylist first
        ArrayList<String[]> RMKdata = new ArrayList<String[]>();
        RMKdata.add(new String[] {
            String.valueOf(RMKResult), String.valueOf((RMKEndTime-RMKStartTime)/1000000000)
        });

        ArrayList<String[]> amaxData = new ArrayList<String[]>();
        amaxData.add(new String[] {
            String.valueOf(amaxResult), String.valueOf((amaxEndTime-amaxStartTime)/1000000000)
        });

        ArrayList<String[]> greedyData = new ArrayList<String[]>();
        greedyData.add(new String[] {
            String.valueOf(greedyResult), String.valueOf((greedyEndTime-greedyStartTime)/1000000000)
        });

        ArrayList<String[]> FPTASdata = new ArrayList<String[]>();
        FPTASdata.add(new String[] {
            String.valueOf(FPTAS_result), String.valueOf((FPTAS_endTime-FPTAS_startTime) /1000000000)
        });
        //write each one so each line of csv has data, new line = new knapsack_item set for all of them
        //all results on a line will have worked on the same exact dataset
        try{
            FileWriter file = new FileWriter("knapsack_output.csv", true);
            PrintWriter writer = new PrintWriter(file);
            writer.print(RMKdata.get(0)[0]);
            writer.print(",");
            writer.print(RMKdata.get(0)[1]);
            writer.print(",");
            writer.print(amaxData.get(0)[0]);
            writer.print(",");
            writer.print(amaxData.get(0)[1]);
            writer.print(",");
            writer.print(greedyData.get(0)[0]);
            writer.print(",");
            writer.print(greedyData.get(0)[1]);
            writer.print(",");
            writer.print(FPTASdata.get(0)[0]);
            writer.print(",");
            writer.print(FPTASdata.get(0)[1]);
            writer.print(",");
            writer.println();
            writer.close();
        }
        catch(IOException e){
            System.out.println("error has occurred");
        }
        
        
    }
}