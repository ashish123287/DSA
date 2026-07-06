class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return b[1] - a[1];
        });
        int prev = intervals[0][0];
        int ans = 1;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= prev) continue;
            ans++;
            prev = intervals[i][0];
        }
        return ans;
    }
}