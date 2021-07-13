import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//

////////////////////////METHOD 1 USING BFS///////////////////////
class Pair {
    int vertex;
    int parent;

    public Pair(int vertex, int parent) {
        this.vertex = vertex;
        this.parent = parent;
    }
}

class app04a {
    // we are taking parent/prev node in account because prev node of any nodeis
    // bound to be visited
    boolean checkForCycleBFS(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int parent[]) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s, -1));
        vis[s] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int vertex = curr.vertex;
            int parentOfVertex = curr.parent;
            for (int it : adj.get(vertex)) {
                if (!vis[it]) {
                    q.add(new Pair(it, vertex));
                    vis[it] = true;
                } else if (vis[it] == true
                        && it != parentOfVertex)/* it is visited and not the parent node then there is a cycle */
                    return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++)
            if (!vis[i] && checkForCycleBFS(adj, i, vis, parent))
                return true;

        return false;
    }
}

//////////////////////// METHOD 2 USING DFS///////////////////////

class app04b {
    public boolean checkForCycleDFS(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {// MAYBE THE reason for not being able to call the recursive function with && is
                           // because it is checking for !vis[](which checks for false) &&
                           // checkForCycleDFS(which makes it true) - so die to contradiction in both the
                           // statements itself we first need to checkfor !vis[] & then onlymake it true
                           // using checkForCycleDFS
                if (checkForCycleDFS(it, node, vis, adj))
                    return true;
            } else if (it != parent)
                return true;
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!vis[i] && checkForCycleDFS(i, -1, vis, adj))
                return true;
        return false;
    }
}