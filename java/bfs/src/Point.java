public class Point{
    public int x;
    public int y;


    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void offset(int x, int y){
        this.x +=x;
        this.y +=y;
    }

    @Override
    public int hashCode() {
        return x*31 + y;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Point){
            Point p = (Point) obj;
            if(p.x==this.x&&p.y==this.y){
                return true;
            }
        }
        return false;
    }
}