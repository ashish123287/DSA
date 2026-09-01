class Solution {
    public int ways(int[] nums, int i, boolean first, int[] dp){
        if(first && i >= nums.length-1) return 0;
        if(!first && i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int skip = ways(nums, i+1, first, dp);
        int pick = nums[i] + ways(nums, i+2, first, dp);
        return dp[i] = Math.max(skip, pick);
    }
    public int rob(int[] nums) {
        // we cannot rob 1st and last house tonight so if we skip 1st we can rob last but if we didn't skip last will not be allowed for robbing.
        if(nums.length == 1) return nums[0];
        boolean first = true;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int skipFirst = ways(nums, 1, !first, dp);
        Arrays.fill(dp, -1);
        int pickFirst = ways(nums, 0, first, dp);
        return Math.max(skipFirst, pickFirst);
    }
}