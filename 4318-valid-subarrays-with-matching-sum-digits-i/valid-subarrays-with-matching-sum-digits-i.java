class Solution {
    public boolean isValid(long n, int x) {
        boolean last = (n % 10 == x);
        while (n >= 10) n /= 10;
        boolean first = (n == x);
        return last && first;
    }

    public int countValidSubarrays(int[] nums, int x) {
        int result = 0;
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i; j < prefix.length; j++) {
                long sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                if (isValid(sum, x)) result++;
            }
        }
        return result;
    }
}