class Solution {
    public void dfs(List<List<Integer>> graph, boolean[] visited, int curr, int[] count) {
        visited[curr] = true;
        count[0]++;                       // number of nodes
        count[1] += graph.get(curr).size(); // sum of degrees
        for (int neigh : graph.get(curr)) {
            if (!visited[neigh]) dfs(graph, visited, neigh, count);
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] count = new int[2]; // count[0]=nodes, count[1]=sum of degrees i.e. size of each list of nodes
                dfs(graph, visited, i, count);
                int nodes = count[0];
                int totalDegree = count[1];
                if (totalDegree == nodes * (nodes - 1)) ans++;
            }
        }
        return ans;
    }
}