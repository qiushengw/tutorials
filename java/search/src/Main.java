public class Main{

    public static int binarySearch(int[] arr, int target, int from, int to){

        if(from < to){
            int mid =(from + to)/2; 
            if(arr[mid]==target){
                return mid;
            }else{
                if(arr[mid]>target){
                    return binarySearch(arr, target, from, mid-1);
                }else{
                    return binarySearch(arr, target, mid+1, to); 
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] array = {1,5,8,89,100,200,500,7000, 80000};
        int targetIndex = binarySearch(array,500,0, array.length-1);

        System.out.println(targetIndex);

    }


}