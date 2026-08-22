class Solution {
    public boolean checkDivisibility(int n) {
        int pro = 1;
        int sum = 0;
        int temp = n;
        while(temp != 0){
            int r = temp%10;
            pro *= r;
            sum += r;
            temp /= 10;
        }
        return n%(pro+sum) == 0;
    }
}