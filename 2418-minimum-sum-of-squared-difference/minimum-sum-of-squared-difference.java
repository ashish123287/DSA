
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        long total = (long) k1 + k2;
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            if (!map.containsKey(d)) map.put(d, 0);
            map.put(d, map.get(d) + 1);
        }
        while (total != 0) {
            int key = map.firstKey();
            if (key == 0) break;
            int freq = map.get(key);
            map.remove(key);
            if (total >= freq) {
                map.put(key - 1, map.getOrDefault(key - 1, 0) + freq);
                total -= freq;
            } else {
                map.put(key - 1, map.getOrDefault(key - 1, 0) + (int) total);
                map.put(key, freq - (int) total);
                total = 0;
            }
        }
        for (int x : map.keySet()) {
            ans += (long) map.get(x) * x * x;
        }

        return ans;
    }
}
