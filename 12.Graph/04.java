import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//

////////////////////////METHOD 1 USING BFS///////////////////////
class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class app04 {

    boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int parent[]) {
        Queue<Node> q = new LinkedList<>(); // BFS
        q.add(new Node(s, -1));
        vis[s] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }

                else if (par != it)
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
            if (vis[i] == false)
                if (checkForCycle(adj, i, vis, parent))
                    return true;

        return false;
    }
}

//////////////////////// METHOD 1 USING DFS///////////////////////
