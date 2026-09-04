class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j <= i; j++) max = Math.max(max, nums[j]);
            int min = Integer.MAX_VALUE;
            for(int j = i; j < n; j++) min = Math.min(min, nums[j]);
            int inst = max - min;
            if(inst <= k) ans = Math.min(ans, i);
        }
        return ans == Integer.MAX_VALUE? -1:ans;
    }
}