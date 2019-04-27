import java.util.*;
import java.util.stream.*;

class Node{
    Point p;
    int distence;

    Node(Point p, int distence){
        this.p = p;
        this.distence = distence;
    }
}

public class MazeMap{

    public int[][] maze;

    public List<Point> getAdjectivePoint(Point p){

        int yoffset[] = {0, -1, 0, +1};
        int xoffset[] = {+1, 0, -1, 0};
        //p.newPointOffset(x, y)
        List<Point> list = new ArrayList<>();
        int orgX = p.x;
        int orgY = p.y;
        IntStream.range(0,4).forEach(n->{
            Point newP = new Point(orgX + xoffset[n], orgY + yoffset[n]);
            int value = maze[newP.x][newP.y];
            if(value == 1){
                list.add(newP);
            }
        });

        return list;
    }


    public int BFS(Point start, Point end){
        if(start.x<0 || start.y<0||start.x>=maze.length || start.y>=maze.length || maze[start.x][start.y]==0||
            end.x<0 || end.y<0||end.x>=maze.length || end.y>=maze.length || maze[start.x][start.y]==0){
            return -1;
        }

        Point current = new Point(start.x, start.y);
        Node currentNode = new Node(current, 0);

        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Point> visited = new LinkedList<>();
        queue.add(currentNode);
        visited.add(current);

        while(!queue.isEmpty()){
            Node front = queue.poll();
            Point pt = front.p;

            if(pt.equals(end)){
                return front.distence;
            }

            List<Point> adjectivePoints = this.getAdjectivePoint(pt);
            for(Point xp : adjectivePoints){
                if(visited.contains(xp)){
                    continue;
                }
                


                if(!visited.contains(xp)) {
                    visited.add(xp);
                    if(xp.equals(end)){
                        return distence;
                    }else{
                        List<Point> nextPList = this.getAdjectivePoint(xp); 

                    }



                }
                visited.add(xp);
                if(start.equals(end)){
                    return distence;
                }




            }
        }

        




        return 0;
    }

    

}