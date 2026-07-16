class Solution {
    public int maxDigitRange(int[] nums) {
        int[] map = new int[nums.length];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int mx = 0;
            int mn = 9;
            while(temp != 0){
                int d = temp%10;
                mx = Math.max(mx, d);
                mn = Math.min(mn, d);
                temp = temp/10;
            }
            map[i] = mx-mn;
            max = Math.max(max, map[i]);
        }

        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            if(map[i] == max) sum += nums[i];
        }

        return sum;
    }
}