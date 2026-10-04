class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length() + 1];
        return solve(s, 0, 0);
    }
    public boolean solve(String s, int i, int open) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;
        if (dp[i][open] != null) return dp[i][open];
        char ch = s.charAt(i);
        if (ch == '(') return dp[i][open] = solve(s, i + 1, open + 1);

        if (ch == ')') return dp[i][open] = solve(s, i + 1, open - 1);

        // '*' → '(', ')' or empty
        return dp[i][open] =
            solve(s, i + 1, open + 1) ||
            solve(s, i + 1, open - 1) ||
            solve(s, i + 1, open);
    }
}