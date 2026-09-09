class Solution {
    public long countCommas(long n) {
        if(n < 1000) return 0;
        long ans = 0;
        long pre = 999;
        if( n >= 1000000 ){
            ans += 999999-pre;
            pre = 999999;
        }
        if(n < 1000000) return n-999;
        if(n >= 1000000000){
            ans += 2*(999999999-pre);
            pre = 999999999;
        }
        if(n < 1000000000) return 2*(n-pre)+ans;
        if(n >= 1000000000000L){
            ans += 3*(999999999999L-pre);
            pre = 999999999999L;
        }
        if(n < 1000000000000L) return 3*(n-pre)+ans;
        if(n == 1000000000000000L){
            ans += 4*(999999999999999L-pre);
            pre = 999999999999999L;
            return ans+5;
        }
        if(n < 1000000000000000L) return 4*(n-pre)+ans;
        return ans;
    }
}