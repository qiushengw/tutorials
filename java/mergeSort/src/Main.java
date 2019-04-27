import java.util.Arrays;

public class Main {

    public void mergeSort(int[] arr) {

        partition(arr, 0, arr.length - 1);

    }

    public void partition(int arr[], int i, int j) {

        if (i < j) {
            int mid = (i + j) / 2;
            partition(arr, i, mid);
            partition(arr, mid + 1, j);
            merge(arr, i, mid, mid + 1, j);
        }

    }

    public void merge(int[] arr, int startA, int endA, int startB, int endB) {
        System.out.printf("startA=%d, endA=%d, startB=%d, endB=%d\n", startA, endA, startB, endB);
        int i = startA;
        int j = startB;
        int len =endB - startA + 1; 

        int temp[] = new int[len];
        int k = 0;
        while (i <= endA && j <= endB) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }

            k++;

        }

        for (int ii = i; ii <= endA; ii++) {
            temp[k] = arr[ii];
            k++;
        }

        for (int jj = j; jj <= endB; jj++) {
            temp[k] = arr[jj];
            k++;
        }

        System.arraycopy(temp, 0, arr, startA, len);

        Arrays.stream(temp).forEach(System.out::println);
        System.out.println();

    }

    public static void main(String[] args) {
        Main main = new Main();
        int arr[] = { 10, 7, 8, 9, 1, 5, 13, 2 };
        main.mergeSort(arr);
    }
}