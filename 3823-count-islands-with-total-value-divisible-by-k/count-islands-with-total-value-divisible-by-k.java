class Solution {
    public long dfs(int[][] grid, int i, int j, int n, int m, boolean[][] visited){
        visited[i][j] = true;
        long down = 0, up = 0, right = 0, left = 0;
        if(i+1 < n && !visited[i+1][j] && grid[i+1][j] != 0){
            down = dfs(grid, i+1, j, n, m, visited);
        }
        if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] != 0){
            up = dfs(grid, i-1, j, n, m, visited);
        }
        if(j+1 < m && !visited[i][j+1] && grid[i][j+1] != 0){
            right = dfs(grid, i, j+1, n, m, visited);
        }
        if(j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] != 0){
            left = dfs(grid, i, j-1, n, m, visited);
        }
        return grid[i][j]+down+up+right+left;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 || visited[i][j]) continue;
                long sum = dfs(grid, i, j, n, m, visited);
                if(sum%k == 0) ans++;
            }
        }
        return ans;
    }
}