class Solution {
    public int minAddToMakeValid(String s) {
        int depth = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') depth++;
            else depth--;
            if(depth < 0){
                ans++;
                depth = 0;
            }
        }
        return ans+depth;
    }
}