class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
            set.add(nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = min; i <= max; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}