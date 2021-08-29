import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAGFG {

    public void BFS(ArrayList<ArrayList<Integer>>adj, int v, int s){
        boolean visited[] = new boolean[v+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(q.isEmpty()==false){
            int u = q.poll();
            System.out.print(u+" ");
            for(int vertex:adj.get(u)){
                if(visited[vertex] == false){
                    q.add(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }
}
