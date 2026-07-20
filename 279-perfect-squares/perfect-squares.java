class Solution {
    public int find(int n, int[] dp, List<Integer> list){
        if(dp[n] != 0) return dp[n];
        if(n == 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i = list.size()-1; i > 0; i--){
            if(n >= list.get(i)) min = Math.min(min, 1+find(n-list.get(i), dp, list));
        }
        dp[n] = min;
        return dp[n];
    }
    public int numSquares(int n) {
        if(n <= 3) return n;
        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 2; dp[3] = 3;
        List<Integer> list = new ArrayList<>();
        int i = 1;
        int sq = i;
        while(sq <= n){
            list.add(sq);
            dp[sq] = 1;
            i++;
            sq = i*i;
        }
        return find(n, dp, list);
    }
}