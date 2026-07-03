class Solution {
    public int ways(int[] nums, int target, int i){
        if( i == nums.length ){
            if(target == 0) return 1;
            else return 0;
        }
        int plus = ways(nums, target-nums[i], i+1);
        int minus = ways(nums, target+nums[i], i+1);
        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums, target, 0);
    }
}