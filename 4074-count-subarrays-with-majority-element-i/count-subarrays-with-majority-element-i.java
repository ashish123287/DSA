class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i< n; i++){
            int nonReq = 0;
            int req = 0;
            for(int j = i; j < n; j++){
                if(nums[j] == target) req++;
                else nonReq++;
                if(req > nonReq) ans++;
            }
        }
        return ans;
    }
}