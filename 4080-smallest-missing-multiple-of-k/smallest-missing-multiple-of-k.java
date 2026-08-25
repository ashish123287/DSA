class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int x: nums) set.add(x);
        int i = 1;
        while(true){
            if(!set.contains(k*i)) return k*i;
            else i++;
        }
    }
}