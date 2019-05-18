import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Main {
    public static int countOddPair(int[] arr1, int[] arr2){
        if(arr1.length==0 || arr2.length == 0) return 0;
        int[] oddArray1 = getOdd(arr1);
        int[] oddArray2 = getOdd(arr2);
        int[] evenArray1 = getEven(arr1);
        int[] evenArray2 = getEven(arr2);

        printArray(oddArray1);
        printArray(oddArray2);
        printArray(evenArray1);
        printArray(evenArray2);
         
        // An element can only be one pair.
        return Math.min(oddArray1.length, evenArray2.length) + Math.min(oddArray2.length, evenArray1.length);
    }

    public static void printArray(int[] array){
       for(int i : array){
           System.out.print(i + " ");
       } 
       System.out.println();
    }
    public static void main(String[] args){
        int a[] = {9, 14, 6, 2, 11};
        int b[] = {8, 4, 7, 20};

        int cnt = countOddPair(a, b);
        System.out.println(cnt);


    }

    public static int[] getOdd(int[] arr){
        int[] oddList = Arrays.stream(arr).filter(n->n%2!=0).toArray();
        return oddList;
    }
    
    public static int[] getEven(int[] arr){
        int[] oddList = Arrays.stream(arr).filter(n->n%2==0).toArray();
        return oddList;
     }

}