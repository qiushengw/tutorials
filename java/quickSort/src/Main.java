import java.util.Arrays;

public class Main{


    public void quickSort(int[] array, int low, int heigh){
        
        if(low<heigh){
            int pivot = patition(array, low, heigh); 

            quickSort(array, low, pivot-1);
            quickSort(array, pivot+1, heigh);
             
        }

    }

    public int patition(int[] array, int low, int heigh){
        int pivot = array[heigh];
        
        int smallerIndex = low-1;

        for(int j=low; j<heigh; j++){
            if(array[j]<=pivot){
                smallerIndex ++;
                if(smallerIndex != j){
                    swap(array, smallerIndex, j);
                }
            }
        }

        swap(array, ++smallerIndex, heigh);
        return smallerIndex; 
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;        
    }

    public static void main(String[] args){
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        Main sort = new Main();
        sort.quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);

    }



}