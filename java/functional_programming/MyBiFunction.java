import java.util.function.BiFunction;

public class MyBiFunction{

    public static void main(String[] args){

        BiFunction<Integer, Integer, Integer> add = (a, b)->a+b;
        

        Integer result = add.apply(3,4);
        System.out.println(result);

    }


}