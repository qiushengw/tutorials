import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainHeap{

    public static void sort(int arr[]){
        int len = arr.length;
        for(int i = len/2 -1; i>=0; i--){
            heapify(arr, len, i);
        }
        System.out.println(">>>>> build heap");
        IntStream.of(arr).forEach(nn->System.out.printf("%d,",nn)); 
        System.out.println("After build heap");
        
        for(int i= len -1; i>=0; i--){
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i] = temp;
            System.out.println("loop i:"+i);
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i){
        System.out.printf("--->>heapify n=%d, i=%d ==>", n, i);
        IntStream.of(arr).forEach(nn->System.out.printf("%d,",nn));
        System.out.println();
        int lagest = i; 
        int left = i * 2 + 1;
        int right = i * 2 +2;

        if(left<n && arr[left]>arr[lagest]){
            lagest = left;
        }

        if(right<n&&arr[right]>arr[lagest]){
            lagest = right;
        }

        if(lagest!=i){
            int swap = arr[lagest];
            arr[lagest] = arr[i];
            arr[i] = swap;

            heapify(arr, n, lagest);

        }
        


        System.out.printf("---<<heapify n=%d, i=%d<==", n, i);
        IntStream.of(arr).forEach(nn->System.out.printf("%d,",nn));
        
        System.out.println();


    }

    public static void main(String[] args){
        System.out.println("thiis Main heap test");
        int arr[] = {7, 3 ,4 ,11, 2, 8, 6, 0};
        sort(arr);

        IntStream.of(arr).forEach(n->System.out.printf("%d,",n));


    }

}