class Solution {
    public boolean knapsack(int[] nums, int i, int sum, int target, Boolean[][] dp){
        if(sum == target) return true;
        if(i == nums.length || sum > target) return false;

        if(dp[i][sum] != null) return dp[i][sum];

        boolean skip = knapsack(nums, i+1, sum, target, dp);
        boolean pick = knapsack(nums, i+1, sum + nums[i], target, dp);

        return dp[i][sum] = (skip || pick);
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length][target+1];
        return knapsack(nums, 0, 0, target, dp);
    }
}
