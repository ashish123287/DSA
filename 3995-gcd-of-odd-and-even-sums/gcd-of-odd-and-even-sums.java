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
        int oddSum = n*n;
        int evenSum = oddSum + n;
        return gcd(oddSum, evenSum);
    }
}