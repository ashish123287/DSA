class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // approach -> firstly find the lcs then add remaining characters btwn the char of lcs
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int lenOfLcs = dp[n][m];
        if(lenOfLcs == 0) return str1+str2;
        StringBuilder lcs = new StringBuilder("");

        while(n > 0 && m > 0){
            if(str1.charAt(n-1) == str2.charAt(m-1)){
                lcs.append(str1.charAt(n-1));
                n--;
                m--;
            }
            else if(dp[n-1][m] >= dp[n][m-1]) n--;
            else m--;
        }
        
        lcs.reverse();
        StringBuilder supersub = new StringBuilder("");
        int i = 0;
        int j = 0;
        int k = 0;
        n = str1.length();
        m = str2.length();
        while(k < lcs.length()){
            while(i != n && str1.charAt(i) != lcs.charAt(k)) supersub.append(str1.charAt(i++));
            while(j != m && str2.charAt(j) != lcs.charAt(k)) supersub.append(str2.charAt(j++));
            i++;
            j++;
            supersub.append(lcs.charAt(k));
            k++;
        }
        while (i < n) supersub.append(str1.charAt(i++));
        while (j < m) supersub.append(str2.charAt(j++));
        return supersub.toString();
    }
}