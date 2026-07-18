class Solution {
    public int minSteps(int i, int j, StringBuilder sb1, StringBuilder sb2, int[][] dp){
        if(i == -1) return j+1;
        if(j == -1) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(sb1.charAt(i) == sb2.charAt(j)) return dp[i][j] = minSteps(i-1, j-1, sb1, sb2, dp);
        else {
            int del = minSteps(i-1, j, sb1, sb2, dp);
            int in = minSteps(i, j-1, sb1, sb2, dp);
            int rep = minSteps(i-1, j-1, sb1, sb2, dp);
            return dp[i][j] = 1 + Math.min(del, Math.min(in, rep));
        }
    }
    public int minDistance(String word1, String word2) {
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return minSteps(m-1, n-1, sb1, sb2, dp);
    }
}