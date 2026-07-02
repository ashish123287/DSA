class Solution {
    public boolean findPath(List<List<Integer>> grid, int health, int[][] best, int n, int m, int i, int j) {
        health -= grid.get(i).get(j);
        if (health < 1) return false;
        if (i == n - 1 && j == m - 1) return true;
        if (best[i][j] >= health) return false;
        best[i][j] = health;
        if (i - 1 >= 0 && findPath(grid, health, best, n, m, i - 1, j)) return true;
        if (i + 1 < n && findPath(grid, health, best, n, m, i + 1, j)) return true;
        if (j + 1 < m && findPath(grid, health, best, n, m, i, j + 1)) return true;
        if (j - 1 >= 0 && findPath(grid, health, best, n, m, i, j - 1)) return true;

        return false;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] best = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(best[i], -1);

        return findPath(grid, health, best, n, m, 0, 0);
    }
}