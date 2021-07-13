import java.util.ArrayList;

//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
class app02 {
    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsList) {
        dfsList.add(node);
        vis[node] = true;
        for (int adjVertex : adj.get(node)) {
            if (!vis[adjVertex]) {
                dfs(adjVertex, vis, adj, dfsList);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfsList = new ArrayList<>();
        boolean vis[] = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!vis[i])
                dfs(i, vis, adj, dfsList);
        }

        return dfsList;
    }
}