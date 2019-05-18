import java.util.*;

public class Main{

    public static void main(String[] args){
        MazeMap mazeMap = new MazeMap();

        int[][] mm = new int[][] {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
            { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } 
        };

        Point newP = new Point(0,0); 
        int distence = mazeMap.BFS(mm, newP, new Point(4,6));
        System.out.println("distence="+ distence);

    }



}