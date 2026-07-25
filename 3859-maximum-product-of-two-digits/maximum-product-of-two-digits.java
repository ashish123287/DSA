class Solution {
    public int maxProduct(int n) {
        String str = Integer.toString(n);
        int l = str.length();
        int[] arr = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            arr[i] = n % 10;
            n = n / 10;
        }
        int max = arr[0];
        int pos = 0;
        for (int i = 1; i < l; i++) {
            if (arr[i] > max) {
                max = arr[i];
                pos = i;
            }
        } 
        int smax = -1;
        for (int i = 0; i < l; i++) {
            if (i == pos) continue;
            if (arr[i] > smax) smax = arr[i];
        }
        return max * smax;
    }

}
