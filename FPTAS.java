
public class FPTAS {

    public static void main(String[] args) {
        amax_knapsack instance = new amax_knapsack();

        knapsack_item list[] = new knapsack_item[20];
        for (int i = 0; i < 20; i++) {
            list[i] = new knapsack_item((int)(Math.random()*20)+1, (int)(Math.random()*10) + 1);
        }

        

        int[] knapsack_values = new int[20];
        for (int i = 0; i < knapsack_values.length; i++) {
            knapsack_values[i] = list[i].getValue();
        }
        int[] knapsack_weights = new int[20];
        for (int i = 0; i < knapsack_weights.length; i++) {
            knapsack_weights[i] = list[i].getCost();
        }
        int temp = instance.solveMaxKnapsack(100,knapsack_values, knapsack_weights );

        System.out.println(temp);
    }


    public static int useFPTAS(){
       
       
        return 0;
    }

}