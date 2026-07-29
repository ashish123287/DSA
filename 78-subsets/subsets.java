class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void subset(int[] nums, List<Integer> temp, int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        //List<Integer> temp = new ArrayList<>();
        // Yes
        temp.add(nums[i]);
        subset(nums , temp , i+1);
        // No
        temp.remove(temp.size()-1);
        subset(nums , temp , i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        //List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subset(nums , temp , 0);
        return ans;
    }
}