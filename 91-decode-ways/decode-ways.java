class Solution {
    public int decodeWays(String s, int i, int[] dp){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int ones = 0;
        int twos = 0;
        ones = decodeWays(s, i+1, dp);
        if(i+1 < s.length()) {
            int n = (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
            if(n>=10 && n<= 26) twos = decodeWays(s, i+2, dp);
        }
        return dp[i] = ones+twos;
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return decodeWays(s, 0, dp);
    }
}