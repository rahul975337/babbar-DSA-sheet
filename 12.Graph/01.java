import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
class app01 {
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();

        boolean visited[] = new boolean[v + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                bfs(i, q, visited, bfs, adj);
            }
        }

        return bfs;
    }

    void bfs(int v, Queue<Integer> q, boolean[] visited, ArrayList<Integer> bfs, ArrayList<ArrayList<Integer>> adj) {
        while (!q.isEmpty()) {
            int curr = q.poll();
            bfs.add(curr);
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int adjVertex : adj.get(curr)) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    q.offer(adjVertex);
                }
            }
        }
    }
}