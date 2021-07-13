import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
//we can also extend this for disconnectedgraph
class app01 {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();
        boolean visited[] = new boolean[V];
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            bfs.add(curr);
            for (int adjVertex : adj.get(curr)) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    q.offer(adjVertex);
                }
            }
        }
        return bfs;
    }
}