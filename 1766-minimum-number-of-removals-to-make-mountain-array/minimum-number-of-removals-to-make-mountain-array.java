class Solution {
    public int minimumMountainRemovals(int[] nums) {
        // try this after leetcode 300
        int n = nums.length;

        int[] dp1 = new int[n];  // maximum length of number in decreasing order towards right at index i;
        dp1[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            int max = 0;
            for(int j = i+1; j < n; j++){
                if(nums[i] > nums[j]) max = Math.max(max, dp1[j]);
            }
            dp1[i] = max+1;
        }

        int[] dp2 = new int[n]; // maximum length of number in decreasing order towards left at index i;
        dp2[0] = 1;
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j]) max = Math.max(max, dp2[j]);
            }
            dp2[i] = max+1;
        }
        
        int maxLen = 0;
        for(int i = 1; i < n-1; i++){
            if(dp1[i] != 1 && dp2[i] != 1) maxLen = Math.max(maxLen, dp1[i]+dp2[i]-1);
        }
        return n-maxLen;
    }
}