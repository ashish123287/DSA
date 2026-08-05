class Solution {
    public void dfs(List<List<Integer>> graph, int curr, Set<Integer> visited){
        visited.add(curr);
        for(int i = 0; i < graph.get(curr).size(); i++){
            if(!visited.contains(graph.get(curr).get(i))) dfs(graph, graph.get(curr).get(i), visited);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < invocations.length; i++){
            graph.get(invocations[i][0]).add(invocations[i][1]);
        }

        Set<Integer> suspiciuos = new HashSet<>();
        dfs(graph, k, suspiciuos);

        for (int[] e : invocations) {
            if (!suspiciuos.contains(e[0]) && suspiciuos.contains(e[1])) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspiciuos.contains(i))
                ans.add(i);
        }

        return ans;

    }
}