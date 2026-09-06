class Solution {
    public int findWays(char[] arr, char[] str, int i, int j, int[][] dp){
        if (j == str.length) return 1;
        if (i == arr.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        // pick
        if (arr[i] == str[j]) {
            ans += findWays(arr, str, i+1, j+1, dp);
        }
        // skip
        ans += findWays(arr, str, i+1, j, dp);
        return dp[i][j] = ans;
    }

    public int numDistinct(String s, String t) {
        char[] arr = s.toCharArray();
        char[] str = t.toCharArray();
        int[][] dp = new int[arr.length][str.length];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return findWays(arr, str, 0, 0, dp);
    }
}