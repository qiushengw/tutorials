package qiushengw.gmail.com;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class PFMainCoreConcept {
    /**
     * No Side-Effect
     * Pure Function
     * Immutability
     * Referential Transparency
     */

    static final double unitprice = 5;
    static double wallet = 100;
    private static double payCoffeeBill(int numberOfcoffee){
        double amount = unitprice*numberOfcoffee;
        wallet-=amount; // cause Side-effect
        return amount;
    }

    //Pure Function : the return is always only related on the paramater and function logic.
    private static double payCoffeePromotion(int numberOfcoffee){
        double amount = unitprice*numberOfcoffee;
        if(LocalDate.now().getDayOfWeek()== DayOfWeek.MONDAY){ // break Pure Function
            amount*=0.8;
        }
        return amount;
    }


    //Immutability
    private static double payCoffeeBill(List<Integer> list){
       int totalCups = list.stream().mapToInt(Integer::intValue).sum();
        double result = unitprice * totalCups;
        list.clear(); // this break the immutability
        return result;
    }

    //Referential Transparency = No-side effect + Pure Fucntion + immutability
    //an expression referentially transparency if replacing it with its corresponding value has no impact on the programs' final result.

    private static int sumTo(int x){
        if(x==0) return 0;
        return x + sumTo(x-1);
    }

    public static void main(String[] args){

        int sumTo6 = sumTo(6);
        int sumTo9 = sumTo(9);
        int sumTo12 = sumTo(12);

        int sum789=sumTo(9) - sumTo(6);
        int sum10_11_12=sumTo(12) - sumTo(9);

        System.out.println("Your sum789 is " + sum789);
        System.out.println("Your sum10_11_12 is " + sum10_11_12);

        int sum789_v2=sumTo9 - sumTo6;
        int sum10_11_12_v2=sumTo12 - sumTo9;

        System.out.println("Your sum789_v2 is " + sum789_v2);
        System.out.println("Your sum10_11_12_v2 is " + sum10_11_12_v2);

    }

}
