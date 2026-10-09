class Solution {
    public int minInsertions(String s) {
        int d = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') d++;
            else if(s.charAt(i) == ')'){
                if(i+1 >= s.length()){
                    ans++;
                    i++;
                }
                else if(s.charAt(i+1) == ')') i++;
                else if(s.charAt(i+1) == '(') ans++;
                d--;
            }
            if(d < 0){
                ans++;
                d = 0;
            }
        }
        return ans+2*d;
    }
}