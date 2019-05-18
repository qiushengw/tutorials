import java.util.HashMap;
import java.util.LinkedList;

class Graph{

    HashMap<String, LinkedList<String>> G = new HashMap<>();

    void addEdge(String v, String v2){
        G.putIfAbsent(v, new LinkedList<>());
        G.get(v).add(v2);
    }
}

public class CountAE{

    

    public void buildGraph(){




    }

    public static void main(String[] args){
        
        

    }

}