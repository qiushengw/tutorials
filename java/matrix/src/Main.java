
public class Main {
    //Linear algebra
    public static   

    public static void main(String[] args){
        int[][] input = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
    

    int[][] ret = turn(input);

    for(int i=0;i<ret.length;i++){
        for(int j=0;j<ret[0].length;j++){
            System.out.print(ret[i][j]+",");
        }
        System.out.println();
    }
    }

}