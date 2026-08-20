class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        int j = 0;
        int k = 0;
        for(int i = 2; i < nums.length; i++){
            if(list1.get(j) > list2.get(k)){
                list1.add(nums[i]);
                j++;
            }
            else {
                list2.add(nums[i]);
                k++;
            }
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < list1.size(); i++) ans[i] = list1.get(i);
        for(int i = 0; i < list2.size(); i++) ans[list1.size()+i] = list2.get(i);
        return ans;
    }
}