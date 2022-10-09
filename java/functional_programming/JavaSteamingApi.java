import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaSteamingApi {
    /**
     *  what is streaming?
     *      Steam self don't any attribute, they just provide a set of transformation, it is data pipeline
     *
     *       Water(sequence) ----> Filter out something(filter) ----> Add food Coloring of each water drop (map)-----> Add(map) -----> Cup(to collect)
     *
     *
     */

    // one is map,  one is flatmap
    private static void waterStream(){
        List<Integer> waters = List.of(1, 2, 3, 4, 5,6);

        // filter out even number

        List<Integer> newList = waters.stream().filter(x -> x%2==1).collect(Collectors.toList());
        System.out.println(newList);




    }



    /***
     * most useful usecase
     *
     *
     */

    // 1. Matrix adding
    private void matrixAdding(){


    }



}
