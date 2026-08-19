class Solution {
    public int maxNumberOfFamilies(int n, int[][] reserved) {
        // here reservedSeaats.length matters not n

        List<Set<Integer>> graph = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < reserved.length; i++) max = Math.max(max, reserved[i][0]);
        for(int i = 0; i < max+1; i++) graph.add(new HashSet<>());
        for(int i = 0; i < reserved.length; i++) graph.get(reserved[i][0]).add(reserved[i][1]);

        int ans = 0;
        int occupied = 0;
        for (Set<Integer> seats : graph) {
            if (!seats.isEmpty()) {
            occupied++;
            }
        }
        ans += 2*(n-occupied);  // we can accomadate atmost 2 groups in a row and there the rows which are not occupied accomadate both 2 groups 

        for(int i = 0; i < graph.size(); i++){
            if (graph.get(i).isEmpty()) continue;
            boolean start = true;
            boolean mid = true;
            boolean last  =  true;
            if(graph.get(i).contains(4) || graph.get(i).contains(5)){
                start = false;
                mid = false;
            }
            if(graph.get(i).contains(6) || graph.get(i).contains(7)){
                last = false;
                mid = false;
            }
            if(start && (graph.get(i).contains(2) || graph.get(i).contains(3))) start = false; 
            if(last && (graph.get(i).contains(8) || graph.get(i).contains(9))) last = false; 
            if (start && last) ans += 2; 
            else if (start || mid || last) ans += 1;
        }
        return ans;
    }
}