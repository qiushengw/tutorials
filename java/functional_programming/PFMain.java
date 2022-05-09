import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class PFMain {
    // 1. No-side effect
    static int mytotalMoney = 100;
    static int coffeeUnitPrice = 5;

    private static int payTheBill(int numberOfCoffee){
        int total = coffeeUnitPrice*numberOfCoffee;
        mytotalMoney=mytotalMoney-total;
        return total;
    }


    // 2. Pure Function : the return of the function always only related to the input parameters
    private static double payTheBillWithPromotion(int numberOfCoffee){
        double totalPay = coffeeUnitPrice*numberOfCoffee;
        if(LocalDate.now().getDayOfWeek()== DayOfWeek.MONDAY){
            totalPay=totalPay*0.8;
        }
        return totalPay;
    }


    //3. Immutability : the function should not change any state of the input paramter
     private static int payTheBill(List<Integer> list){
        int total = list.stream().mapToInt(Integer::intValue).sum();
         list.add(total); // mutate the list !!!

        return total;
     }

     //4. Referential Transparency: We call an expression referentially transparent if replacing it with its corresponding value has no impact on the program's behavior.
     private static int sumTo(int x){
        if(x==0) return 0;
        return x+sumTo(x-1);
     }


    public static void main(String args[]){

        int sumTo6 = sumTo(6);
        int sumTo9 = sumTo(9);
        int sumTo12 = sumTo(12);


        int sum789 = sumTo(9) - sumTo(6);

        int sum10_11_12 = sumTo(12) - sumTo(9);


        System.out.println("You sum789 : " + sum789);
        System.out.println("You sum10_11_12 : " + sum10_11_12);

        int sum789_v2 = sumTo9 - sumTo6;
        System.out.println("You sum789 : " + sum789_v2);

        int sum10_11_12_v2 = sumTo12 - sumTo9;
        System.out.println("You sum10_11_12 : " + sum10_11_12_v2);





        int paidAmount = payTheBill(3);
        System.out.println("You Paid : " + paidAmount + " You still have " + mytotalMoney + " in your wallet");

        int paidAmount_v2 = payTheBill(3);
        System.out.println("You Paid : " + paidAmount_v2 + " You still have " + mytotalMoney + " in your wallet");

        int paidAmount_v3 = payTheBill(3);
        System.out.println("You Paid : " + paidAmount_v3 + " You still have " + mytotalMoney + " in your wallet");


    }

}
