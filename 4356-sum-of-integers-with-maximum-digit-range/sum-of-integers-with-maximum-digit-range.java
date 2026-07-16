class Solution {
    public int maxDigitRange(int[] nums) {
        int[] map = new int[nums.length];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            String s = nums[i]+"";
            int mx = 0;
            int mn = 9;
            for(int j = 0; j < s.length(); j++){
                int ch = s.charAt(j)-'0';
                mx = Math.max(mx, ch);
                mn = Math.min(mn, ch);
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