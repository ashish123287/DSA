class Solution {
    List<String> ans = new ArrayList<>();
    public void helper(String str, int i, int j, int n){
        if(i == n && j == n){
            ans.add(str);
            return;
        }
        if(i < n){
            helper(str+"(", i+1, j, n);
        }
        if(j < i){
            helper(str+")", i, j+1, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        helper("", 0, 0, n);
        return ans;
    }
}
