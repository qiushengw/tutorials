import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyBiFunction{
    public static void main(String[] args){
        Function<Double, Double> log = (x)-> Math.log(x);

        BiFunction<Integer, Integer, Integer> add = (a, b)->a+b;
        BiFunction<Integer, Integer, Integer> minus = (a, b)->Math.abs(a-b);

        List<BiFunction> optlist = Arrays.asList(add, minus);

        Integer result = add.apply(-1111111, 1111111 );
        Random rand = new Random();

        int score = 0;
        int connectiveCorrect = 0;

        int i=10;
        while(i-->0){
            int a = rand.nextInt(100);
            int b = rand.nextInt(150);
            int type = rand.nextInt(2);

            if(type==0){
                System.out.println((10-i) + ".What is the result of " + a + "+" + b);
            }else{
                if(a>b){
                    System.out.println((10-i) + ".What is the result of " + a + "-" + b);
                }else{
                    System.out.println((10-i) + ".What is the result of " + b + "-" + a);
                }

            }
            Scanner scanner = new Scanner(System.in);
            result = scanner.nextInt();


            if (result.equals(optlist.get(type).apply( a , b))){
                System.out.println("You are right");
                score = score + 10;
                connectiveCorrect = connectiveCorrect+1;
            }else{
                System.out.println("You are wrong");
                connectiveCorrect = 0;
            }

            if(connectiveCorrect>4){
                System.out.println("********Excellent !!!**********");
            }
        }

        System.out.println("You score is "+ score);

    }


}