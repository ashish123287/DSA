class Solution {
    public int helper(Map<Integer,Integer> map, int i, int j){
        int ans = 0;
        while(i <= j){
            if(map.get(i) == i + 1) ans += 1;
            else if(map.get(i) == j) ans += 2 * helper(map, i + 1, map.get(i) - 1);
            else ans += helper(map, i, map.get(i));
            i = map.get(i) + 1;
        }
        return ans;
    }

    public int scoreOfParentheses(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') st.push(i);
            else map.put(st.pop(), i);
        }

        return helper(map, 0, s.length() - 1);
    }
}