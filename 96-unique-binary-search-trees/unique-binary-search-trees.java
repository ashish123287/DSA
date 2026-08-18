class Solution {
    public int totalTrees(int l, int r, int[][] dp){
        if(l > r) return 0;
        else if(r == l) return 1;
        if(dp[l][r] != -1) return dp[l][r];
        int sum = 0;
        for(int i = l; i <= r; i++){
            int left = totalTrees(l, i-1, dp);
            int right = totalTrees(i+1, r, dp);
            if(left == 0 || right == 0) sum += Math.max(left, right);
            else sum += left*right;
        }
        return dp[l][r] = sum;
    }
    public int numTrees(int n) {
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);;
        return totalTrees(0, n-1, dp);
    }
}