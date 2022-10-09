
package qiushengw.gmail.com;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PFMainSteam {
    // Consumer is expected to operate via side-effects.
    public static Consumer<String> consumer = System.out::println;
    public static Predicate<String> predicater = MethodRepo::lessthen4;
    public static Function<String, String> mapper = t -> t.substring(0,3);
    public static ToIntFunction<String> toDoubleMapper = t -> t.length();
    public static Function<String, Stream<String>> splitsteam = (a) -> Stream.of(a.split(""));
    public static ToIntBiFunction<Integer, Integer> add = (a,b) -> a+b;
    public static BiFunction<String, String, String> bifunc = (a,b)-> a.concat("_"+b);
    public static BinaryOperator<String> reduce =(a,b)-> {
        System.out.println("a["+a+"]" + " b["+b+"]");
        return a.concat("_"+b);
    };

   // public static BinaryOperator<T> accumulator = null;

    // Lambda and method reference

    public static void main(String[] args) {
        PFMainSteam.consumer.accept("Hello");
        System.out.println(PFMainSteam.predicater.test("abcd"));

        String fullname = bifunc.apply("wang", "qiusheng");
        consumer.accept(fullname);

        String result = mapper.apply("Qiusheng Wang");
        consumer.accept(result);

        int len = toDoubleMapper.applyAsInt("Qiusheng Wang");
        System.out.println(len);

        int re = add.applyAsInt(100, 200);
        System.out.println(re);

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };

       // Predicate<String> predicate = x -> x.startsWith("J");
        //List<String> list = Arrays.stream(stringArray).filter(predicate).collect(Collectors.toList());

        List<String> list = Arrays.stream(stringArray).map( t -> t.substring(0,3)).collect(Collectors.toList());
        list = Arrays.stream(stringArray).map( t -> t.substring(0,3)).sorted(
                (x,y) -> y.compareTo(x)
        ).collect(Collectors.toList());

        list= Arrays.stream(stringArray).flatMap(x->Arrays.stream(x.split(""))).collect(Collectors.toList());
        list.stream().forEach(consumer);

        String longstr = Arrays.stream(stringArray).reduce(reduce).get();
        consumer.accept(longstr);


        Integer[][] matrix = {
                {1,0,1,0,1,0},
                {2,1,1,1,1,1},
                {3,2,1,1,1,1},
        };

        BinaryOperator<Integer> verticleSum = (a,b) -> a + b;

        List<Integer> sumResult = new ArrayList<>();
        for(Integer[] arr : matrix){
            Integer big = Arrays.stream(arr).reduce(verticleSum).get();
            sumResult.add(big);
        }

        sumResult.stream().forEach(System.out::println);




    }




}
