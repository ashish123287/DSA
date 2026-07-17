class Solution {
    public int subseq(StringBuilder text1, StringBuilder text2, int i, int j, int[][] dp){
        if(i == -1 || j == -1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) return dp[i][j] = 1+subseq(text1, text2, i-1, j-1, dp);
        else return dp[i][j] = Math.max(subseq(text1, text2, i, j-1, dp), subseq(text1, text2, i-1, j, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        StringBuilder sb1 = new StringBuilder(text1);
        StringBuilder sb2 = new StringBuilder(text2);    

        int[][] dp = new int[n][m];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return subseq(sb1, sb2, text1.length()-1, text2.length()-1, dp);   // we doesnt pass string but we pass stringbuilder of bcz string is passed by value(everytime a copy of string is created) but sb is passed by reference
    }
}

// Tabulation :-
//          for(int i = 1; i <= n; i++){
//                  for(int j = 1; j <= m; j++){
//                         if(text1.charAt(i-1) == text2.charAt(j-1)){
//                              dp[i][j] = 1 + dp[i-1][j-1];
//                          } else {
//                              dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                          }
//                      }
//                  }

//         return dp[n][m];