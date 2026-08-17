class Solution {
    public int stoneGame(int[] prefix, int i, int n, int[][] dp){
        if(i == n) return 0;
        if(dp[i][n] != -1) return dp[i][n];

        int k = i;
        int max = Integer.MIN_VALUE;
        while(i < n){
            int pre = 0;
            if(k != 0) pre = prefix[k-1];
            int left = prefix[i]-pre;
            int right = prefix[n]-prefix[i];

            if(left < right) max = Math.max(max, left + stoneGame(prefix, k, i, dp));
            else if(left > right) max = Math.max(max, right + stoneGame(prefix, i+1, n, dp));
            else {
                max = Math.max(max,
                    Math.max(
                        left + stoneGame(prefix, k, i, dp),
                        right + stoneGame(prefix, i + 1, n, dp)
                    )
                );
            }
            i++;
        }
        return dp[k][n] = max;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int[] prefix = new int[n];
        prefix[0] = stoneValue[0];
        for(int i = 1; i < n; i++) prefix[i] = prefix[i-1]+stoneValue[i];
        return stoneGame(prefix, 0, n-1, dp);
    }
}