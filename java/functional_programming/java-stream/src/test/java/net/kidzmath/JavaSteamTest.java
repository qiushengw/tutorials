package net.kidzmath;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaSteamTest {

    Consumer<Object> plr = System.out::println;

    /**
     * get a numbers list which greater then 3
     */
    @Test
    public void filter() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6);
        List<Integer> newNubers = numbers.stream().filter(x->x>3).collect(Collectors.toList());

        assertEquals(2, newNubers.size());
        newNubers.forEach(plr);

    }

    /**
     * Generate a list based on a given list, and get the cube value of the original number.
     */
    @Test
    public void map() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6);
        List<Double> newNubers = numbers.stream().filter(x->x>3).map(x->Math.pow((x+0.0),3)).collect(Collectors.toList());

        assertEquals(2, newNubers.size());
        assertEquals(125, newNubers.get(0));
        assertEquals(216, newNubers.get(1));

        newNubers.forEach(plr);

    }

    /**
     * sort above result in reverse order
     */
    @Test
    public void sort() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6);
        List<Double> newNubers = numbers.stream().filter(x->x>3).map(x->Math.pow((x+0.0),3))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertEquals(2, newNubers.size());
        assertEquals(125, newNubers.get(1));
        assertEquals(216, newNubers.get(0));

        newNubers.forEach(plr);

    }


    /**
     * filter out duplicate value from above result
     */
    @Test
    public void collectors_tomap(){
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 5);

        Map<String, Double> newNubers = numbers.stream().filter(x->x>3).map(x->Math.pow((x+0.0),3))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toMap( k ->  "Key-".concat(String.valueOf(k)),  k->k , (x1,x2) -> x2));


        assertEquals(2, newNubers.keySet().size());
        assertEquals(125, newNubers.get("Key-125.0"));
        assertEquals(216, newNubers.get("Key-216.0"));


        newNubers.values().forEach(plr);
        newNubers.keySet().forEach(plr);

    }

    /**
     * Summaries the list to get a total number
     */
    @Test
    public void collectors_reduce(){
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 5, 100,200, 213);
        int identity = 0;
        Integer summary = numbers.stream().reduce(identity, (a,b) -> {
                    System.out.println("identity:" + identity + " a:" + a + " b:" + b);
                    return a + b;
                }
        );

        assertEquals(535, summary);

    }

}
