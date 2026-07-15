class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int oddSum = (n*(2+(n-1)*2))/2;
        int evenSum = (n*(4+(n-1)*2))/2;
        return gcd(oddSum, evenSum);
    }
}