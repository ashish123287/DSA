class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long maxSum = 0;
        long minSum = 0;
        for(int i = 0; i < n; i++){
            if(i < n/2) minSum += nums[i];
            else maxSum += nums[i];
        }
        return maxSum-minSum;
    }
}