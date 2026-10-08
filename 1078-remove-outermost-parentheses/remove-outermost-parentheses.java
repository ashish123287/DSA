class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        int d = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                d++;
                if(d > 1) sb.append(ch);
            }
            else{
                if(d > 1) sb.append(ch);
                d--;
            }
        }
        return sb.toString();
    }
}