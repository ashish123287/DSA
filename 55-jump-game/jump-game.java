class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n];
        check[n-1] = true;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] == 0) continue;
            int k = 1;
            while(i+k < n && k <= nums[i]){
                if(check[i+k++]){
                    check[i] = true;
                    break;
                }
            }
        }
        return check[0];
    }
}