class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int i = 0, j = 0;

        for (int k = 0; k < n; k++) {
            if (nums[k] < min) {
                min = nums[k];
                i = k;
            }
            if (nums[k] > max) {
                max = nums[k];
                j = k;
            }
        }
        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        int left = j + 1;          
        int right = n - i;             
        int mix1 = (i + 1) + (n - j);  
        int mix2 = (j + 1) + (n - i);  

        return Math.min(Math.min(left, right), Math.min(mix1, mix2));
    }
}
