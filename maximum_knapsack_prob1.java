import java.nio.IntBuffer;
import java.util.Arrays;

//Maximum Knapsack
public class maximum_knapsack_prob1 {

    public static void main(String[] args){
        System.out.println("hello");
       

        //int test = RMK(100, knapsack_values, knapsack_weights);

        //System.out.println("result: " + test);

    }





    public static int RMK(int b, int[] values, int[] weights ){
        int n = values.length;
        //this is going to be the f table
        int F_table[][] = new int[n+1][b + 1];
        //base case
        if (n == 0 || b == 0){
            return 0;
        }
        //populate bottom row with 0's
        for (int i = 0; i < b; i++) {
            F_table[n][i]=0;
        }
        //populate colum with 0
        for (int i = 0; i < n + 1 - 1; i++) {
            F_table[i][0] = 0;
        }
        




        //WARNING CODE DOES NOT WORK BEYOND THIS POINT PROCEED WITH CAUTION
        //now populate whole table
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= b; j++) {
                
                if (j<= weights[i]){
                    F_table[i][j] = F_table[i][j];
                }
                else{
                    F_table[i][j] = Math.max(F_table[i+1][j],F_table[i+1][j-weights[i]]+values[i]);
                }
                //System.out.println("value inserted into f table is " + F_table[i][j]);
            }
        }
        //outside the for loop
        
        return F_table[1][b];

    }
}


//create 2d array with values and weights

//base case f(v,w) = 0 (if v starts at 0) fill in 1st column and last row w 0

//fill in f table bottom up;