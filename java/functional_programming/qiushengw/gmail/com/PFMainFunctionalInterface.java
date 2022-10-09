
package qiushengw.gmail.com;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


public class PFMainFunctionalInterface {

    /**
     What is Functional Interface
     It presents a signature (@FunctionalInterface), It contains only one abstract method
     e.g. Runnable::run, Comparator::compare
     */
    public Runnable timestampLogging = new Runnable() {
        @Override
        public void run() {
            while(true){
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    /**
     * What is different, compare with Functional Interface and other normal Interface
     * We can use Lambda Expression as Method body to do the implementation.
     */
    public Runnable timestampLogging2 = () -> {
        while(true){
            System.out.println(LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };



    public static void main(String[] args) {
       /*
        PFMainFunctionalInterface fi = new PFMainFunctionalInterface();
        Thread thread = new Thread(fi.timestampLogging2);
        thread.start();
        */

        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
        List<Integer> list2 = new ArrayList<>();
        Integer[] numbers = new Integer[]{0, 1, 2, 3, 4, 5};
        List<Integer> list3 = new ArrayList<>(Arrays.asList(numbers));

        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println(list.equals(list2));
        System.out.println(list3.equals(list2));


        Summary<Integer> summary = new Summary<>();
        Integer result = summary.sum(list, (x, y) -> x == null ? y : x.intValue() + y.intValue());
        System.out.println(result);
    }


}
