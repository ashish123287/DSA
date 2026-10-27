class Solution {
    public String[] createGrid(int n, int m) {
        String[] ans = new String[n];
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < m; i++) sb.append('.');
        ans[0] = sb.toString();
        for(int i = 1; i < n; i++){
            sb = new StringBuilder("");
            for(int j = 0; j < m; j++){
                if(j == m-1) sb.append('.');
                else sb.append('#');
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}