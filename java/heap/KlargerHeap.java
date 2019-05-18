import java.util.stream.IntStream;

public class KlargerHeap{

    public static void buildHeap(int[] arr){
        for(int i=arr.length/2-1;i>=0;i--){
            heapify(arr, arr.length, i); 
        }


    }
    public static void heapify(int arr[], int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && arr[l]>arr[largest]){
            largest = l;
        }

        if(r<n && arr[r]>arr[largest]){
            largest = r;
        }

        if(largest != i){

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr, n, largest);

        }



    }

    public static void main(String[] args){
        int[] arr= {45, 2, 5, 7, 100, 200, 3,0, -1};        

        buildHeap(arr);

        IntStream.of(arr).forEach(System.out::println);

    }

}