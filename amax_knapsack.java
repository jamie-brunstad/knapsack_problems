import javax.swing.text.InternationalFormatter;
import java.math.*;

public class amax_knapsack {
    //problem 2

    public static void main(String[] args) {
        // knapsack_item list[] = new knapsack_item[20];
        // for (int i = 0; i < 20; i++) {
        //     list[i] = new knapsack_item((int)(Math.random()*20)+1, (int)(Math.random()*10) + 1);
        // }

        

        // int[] knapsack_values = new int[20];
        // for (int i = 0; i < knapsack_values.length; i++) {
        //     knapsack_values[i] = list[i].getValue();
        // }
        // int[] knapsack_weights = new int[20];
        // for (int i = 0; i < knapsack_weights.length; i++) {
        //     knapsack_weights[i] = list[i].getCost();
        // }

        // int test = solveMaxKnapsack(70, knapsack_weights, knapsack_values);

        // System.out.println("regular amax: " + test);

        // int testFPTAS = useFPTAS(70, knapsack_values, knapsack_weights, 2);

        // System.out.println("FPTAS instance: "  + testFPTAS);
    }



    //p140 txtbook

    public static int solveMaxKnapsack(int capacity, int costs[], int values[]){
        int great_value = 0;
        int space_left = capacity;
        int a_max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > a_max){
                a_max = values[i];
            }
        }
        //now we have set a_max to the maximum value
        int n = values.length;

        int [][] mincost = new int[n+1][n * a_max + 1];
        for (int i = 0; i < mincost.length; i++) {
            mincost[i][0] = 0;
        }
        //now we have the 0s along the bottom row right?
        for (int target = 0; target < values[01]; target++) {
            mincost[1][target] = costs[0];

        }
        
        for (int i = values[1] + 1; i < mincost[0].length; i++) {
            mincost[1][i] = Integer.MAX_VALUE - 100000000;
        }
        //populate the table recursively

        // System.out.println("length of values "+values.length);
        // System.out.println("length of mincost " + mincost.length);
        // System.out.println("len of mincost[0] " + mincost[0].length);
        for (int i = 2; i < mincost.length; i++) {
            for (int j = 0; j < mincost[0].length; j++) {
                int next_t = Math.max(0, j-values[i-1]);
                mincost[i][j] = Math.min(mincost[i-1][next_t] + costs[i-1], mincost[i-1][j]);
            }
        }
        for (int i = 0; i < mincost.length; i++) {
            for (int j = 0; j < mincost[0].length; j++) {
               // System.out.print(" " + mincost[mincost.length-1][j]);

            }
            //System.out.println();
        }
        //System.out.println("capacity : " + capacity);
        for (int i = 0; i < mincost[0].length; i++) {
            //System.out.println("mincost n i : " + mincost[n][i]);
            if(mincost[n][i] >= capacity){
                return i;
            }
            
        }

        return 0;
    }


    public static int useFPTAS(int capacity, int[] values, int [] weights, int scaling_factor){
        int scaled_values [] = new int [values.length];
        for (int i = 0; i < values.length; i++) {
           scaled_values[i] = (int)Math.floor((values[i]/scaling_factor));
        }

        return solveMaxKnapsack(capacity, weights, scaled_values) * scaling_factor;
    }

} 