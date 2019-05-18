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

    public int ROW;
    public int COL;
    private int rowNum[] = {0, -1, 0, +1};
    private int colNum[] = {+1, 0, -1, 0};
    
    boolean isValid(int row, int col){
        return (row>=0 && row <ROW) && (col>=0 && col<COL);
    }


    public int BFS(int[][] maze, Point start, Point end){
        if(start.x<0 || start.y<0||start.x>=maze.length || start.y>=maze.length || maze[start.x][start.y]==0||
            end.x<0 || end.y<0||end.x>=maze.length || end.y>=maze.length || maze[start.x][start.y]==0){
            return -1;
        }

        this.ROW = maze.length;
        this.COL = maze[0].length;

        System.out.printf("ROW=%d, COL=%d\n", this.ROW, this.COL);

        int[][] visited = new int[ROW][COL]; 
        visited[start.x][start.y] = 1;
        LinkedList<Node> queue = new LinkedList<>();
        Node currentNode = new Node(start, 0);
        queue.add(currentNode);

        while(!queue.isEmpty()){
            Node curr = queue.peek();
            Point pt = curr.p;
            if(pt.equals(end)){
                return curr.distence;
            }

            queue.pop();
            for(int i=0;i<4;i++){
               int row = pt.x + rowNum[i];
               int col = pt.y + colNum[i];
                
              System.out.print("isValid="+isValid(row, col)); 
              System.out.printf(" maze[%d][%d]", row, col); 
           System.out.printf(" visitied[%d][%d]\n",row, col); 


               if(isValid(row, col) && maze[row][col]==1 && visited[row][col]==0){
                 visited[row][col] = 1;
                 Node newNode = new Node(new Point(row, col),curr.distence+1);
                 queue.push(newNode); 
               }

            }
            
        }

        return -1;
    }

    

}