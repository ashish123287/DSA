class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        boolean open = true;
        ans[0] = 1; 
        for(int i = 1; i < n; i++){
            if(open){
                if(seq.charAt(i) == ')') ans[i] = 1;
                open = false;
            }
            else if(!open){
                if(seq.charAt(i) == '(') ans[i] = 1;
                open = true;
            }
        }
        return ans;
    }
}