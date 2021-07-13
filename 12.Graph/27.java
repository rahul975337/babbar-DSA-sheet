import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/bipartite-graph/
class app27 {
    boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while (!q.isEmpty()) {
            Integer nde = q.poll();

            for (Integer it : adj.get(nde)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[nde];
                    q.add(it);
                } else if (color[it] == color[nde]) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}