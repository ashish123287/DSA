class Solution {
    public int minSum(List<List<Integer>> triangle, int i, int j, int[][] dp){
        if(i == triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j] != -10001) return dp[i][j];
        int jth = triangle.get(i).get(j) + minSum(triangle, i+1, j, dp);
        int jthPlusOne = triangle.get(i).get(j) + minSum(triangle, i+1, j+1, dp);
        return dp[i][j] = Math.min(jth, jthPlusOne);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -10001);
        return minSum(triangle, 0, 0, dp);
    }
}