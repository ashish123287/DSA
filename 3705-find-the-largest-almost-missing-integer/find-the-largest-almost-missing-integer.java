class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>(); 
        int max = -1;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
            max = Math.max(max, nums[i]);
        }
        if(k == 1){
            int ans = -1;
            for(int x: map.keySet()){
                if(map.get(x) > 1) continue;
                ans = Math.max(ans, x);
            }
            return ans;
        }
        if(k == n) return max;
        if(map.get(nums[0]) > 1 && map.get(nums[n-1]) > 1) return -1;
        if(map.get(nums[0]) > 1 && map.get(nums[n-1]) == 1) return nums[n-1];
        if(map.get(nums[0]) == 1 && map.get(nums[n-1]) > 1) return nums[0];
        return Math.max(nums[0], nums[n-1]);
    }
}