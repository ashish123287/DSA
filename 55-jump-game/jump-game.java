class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int close = n-1;    // most close true index from where we can reach end index
        for(int i = n-1; i >= 0; i--){
            if(close <= i+nums[i]) close = i;
        }
        return close == 0;
    }
}