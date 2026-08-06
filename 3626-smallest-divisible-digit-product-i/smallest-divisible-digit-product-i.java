class Solution {
    public int product(int n){
        int prod = 1;
        while(n != 0){
            prod = prod*(n%10);
            n = n/10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        int ans = 0;
        for(int i = n; i < 1000; i++){
            if(product(i)%t == 0) return i;
        }
        return 0;
    }
}