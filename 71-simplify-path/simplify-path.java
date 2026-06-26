class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        int ptr = 0;
        int n = path.length();
        for (int i = 1; i <= n; i++) {
            if (i == n || path.charAt(i) == '/') {
                String str = path.substring(ptr + 1, i);
                if (!str.equals("") && !str.equals(".")) {
                    if (str.equals("..")) {
                        if (!st.isEmpty()) st.pop();
                    } 
                    else st.push(str);
                }
                ptr = i;
            }
        }
        if (st.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String dir : st) {
            sb.append("/").append(dir);
        }
        return sb.toString();
    }
}