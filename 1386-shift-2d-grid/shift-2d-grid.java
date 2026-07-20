class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // try to simulate and visualise
        int n = grid.length;
        int m = grid[0].length;
        int x = 0;
        int[] flattened = new int[n*m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) flattened[x++] = grid[i][j];
        }
        int total = n*m;
        k = k%total;
        k = (total-k)%total;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j < m; j++) ans.get(i).add(flattened[(k++)%total]);
        }
        return ans;
    }
}