class Solution {
    public int maxDepth(String s) {
        int paren = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') paren++;
            else if(s.charAt(i) == ')'){
                ans = Math.max(ans, paren);
                paren--;
            }
        }
        return ans;
    }
}