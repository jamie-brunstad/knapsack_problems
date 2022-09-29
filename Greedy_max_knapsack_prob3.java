import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Greedy_max_knapsack_prob3{
    public static void main(String[] args) {
        // System.out.println("hello");
        // knapsack_item list[] = new knapsack_item[20];
        // for (int i = 0; i < 20; i++) {
        //     list[i] = new knapsack_item((int)(Math.random()*20)+1, (int)(Math.random()*10) + 1);
        // }

        // int test = newGMK(list, 100);

        // System.out.println(test);


        

    }

    public static int newGMK(knapsack_item list[], int budget){
        int space_left_in_sack = budget;
        int optimal_value = 0;

       // list[].getRatiod
       //bubba sort
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if(list[j].getRatiod() < list[j+1].getRatiod()){
                    //swap
                    knapsack_item temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        //now we have a list[] knapsack_item sorted by their ratio

        for (int i = 0; i < list.length; i++) {
            if(list[i].getCost() <= space_left_in_sack){
                optimal_value += list[i].getValue();
                //System.out.println("list item value: " + list[i].getValue());
                //System.out.println(optimal_value);
                space_left_in_sack -= list[i].getCost();
            }
        }

        return optimal_value;


    }



}