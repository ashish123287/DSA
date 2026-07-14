class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] check = new int[n];
        check[n-1] = 1;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] == 0) continue;
            int k = 1;
            int min = Integer.MAX_VALUE;
            while(i+k < n && k <= nums[i]){
                if(check[i + k] > 0) min = Math.min(min, check[i+k]);
                k++;
            }
            check[i] = min+1;
        }
        return check[0]-1;
    }
}