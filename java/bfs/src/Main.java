import java.util.*;

public class Main{

    public static void main(String[] args){
        MazeMap mazeMap = new MazeMap();

        mazeMap.maze =new int[][] {
            {1,1,0,1},
            {0,1,0,0},
            {0,1,0,0}
        };

        Point newP = new Point(1,1); 
        List<Point> list = mazeMap.getAdjectivePoint(newP);
        list.forEach(n->System.out.println(n.x + "," + n.y));
    }


}