class Solution {
    public void helper(int[] arr, int target, int sum, int i, List<Integer> temp, List<List<Integer>> ans){
        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j < arr.length; j++){
            if(sum+arr[j] <= target){
                temp.add(arr[j]);
                helper(arr, target, sum+arr[j], j, temp, ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            helper(arr, target, arr[i], i, temp, ans);
        }
        return ans;
    }
}