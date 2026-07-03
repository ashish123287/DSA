class Solution {
    public int ways(int[] nums, int target, int i, int[][] dp, int scale){
        if (target < -scale || target > scale) return 0;

        if( i == nums.length ){
            if(target == 0) return 1;
            else return 0;
        }
        if(dp[i][target+scale] != -1) return dp[i][target+scale];
        int plus = ways(nums, target-nums[i], i+1, dp, scale);
        int minus = ways(nums, target+nums[i], i+1, dp, scale);
        return dp[i][target+scale] = plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {

        int total_sum = nums[0];
        for(int i = 1; i < nums.length; i++) total_sum += nums[i];
        if (Math.abs(target) > total_sum) return 0;
        int[][] dp = new int[nums.length][2*total_sum+1];
        int scale = total_sum;
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);

        return ways(nums, target, 0, dp, scale);
    }
}