class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int q = n / 8;
        int r = n % 8; 

        int pushes = 0;
        for (int i = 1; i <= q; i++) pushes += i*8;
        pushes += (q + 1) * r;
        return pushes;
    }
}
