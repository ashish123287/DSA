class Solution {
    public void reverse(char[] chars, int i, int j){
        while(i < j){
            while(chars[i] == '(') i++;
            while(chars[j] == ')') j--;
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(') st.push(i);
            else if(chars[i] == ')') reverse(chars, st.pop()+1, i-1);
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(' || chars[i] == ')') continue;
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}