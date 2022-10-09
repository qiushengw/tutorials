package net.kidzmath;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
//https://github.com/qiushengw/tutorials/blob/master/java/functional_programming/java-stream/src/test/java/net/kidzmath/JavaSteamTest.java

public class JavaSteamTest {
    Consumer<Object> prl = System.out::println;


    /**
     * get a numbers list which greater than 3
     */
    @Test
    public void filter() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6);
        List result = new ArrayList();

        result = numbers.stream().filter(x->x>3).collect(Collectors.toList());



        assertEquals(2, result.size());
        result.forEach(prl);
    }

    /**
     * Generate a list based on a given list, and get the cube value of the original number.
     */
    @Test
    public void map() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6);
        //List result = new ArrayList();

       List<Double> result = numbers.stream().filter(x->x>3).map(x->Math.pow(x,3)).collect(Collectors.toList());


        assertEquals(2, result.size());
        assertEquals(125, result.get(0));
        assertEquals(216, result.get(1));

        result.forEach(prl);
    }

    /**
     * sort above result in reverse order
     */
    @Test
    public void sort() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6);


        List<Double> result = numbers.stream().filter(x->x>3).map(x->Math.pow(x,3)).sorted(Comparator.reverseOrder()).collect(Collectors.toList());




        assertEquals(2, result.size());
        assertEquals(216, result.get(0));
        assertEquals(125, result.get(1));
        result.forEach(prl);

    }


    /**
     * filter out duplicate value from above result
     */
    @Test
    public void collectors_tomap(){
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 5);
        //List result = new ArrayList();

        Map<String, Double> resultMap = numbers.stream().filter(x->x>3).map(x->Math.pow(x,3)).sorted(Comparator.reverseOrder())
                .collect(Collectors.toMap(
                k -> "Key-".concat(String.valueOf(k)),
                        v->v,
                        (x1,x2) -> x2
        ));

        Collection<Double> result = resultMap.values();

        assertEquals(2, result.size());
     //   result.forEach(prl);
    }

    /**
     * Summaries the list to get a total number
     */
    @Test
    public void collectors_reduce(){
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 5, 100,200, 213);
        int sum = 0;
        final int identity = 0;
        sum = numbers.stream().reduce(identity,(x,y)->
                {
                    System.out.println("identity:" + identity + " x:"+x + " y:" + y);
                    return x + y;
                }
        );


        assertEquals(535, sum);
    }

}
