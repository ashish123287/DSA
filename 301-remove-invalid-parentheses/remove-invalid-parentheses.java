class Solution {
    Set<String> set = new HashSet<>();
    public boolean isValid(StringBuilder sb) {
        int d = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') d++;
            else if (c == ')') d--;
            if (d < 0) return false;
        }
        return d == 0;
    }
    public void helper(String s, int i, int invalid, StringBuilder sb) {
        if (i == s.length()) {
            if (invalid == 0 && isValid(sb)) {
                set.add(sb.toString());
            }
            return;
        }
        // Remove current character
        if (invalid > 0 && (s.charAt(i) == '(' || s.charAt(i) == ')')) {
            helper(s, i+1, invalid-1, sb);
        }
        // Keep current character
        sb.append(s.charAt(i));
        helper(s, i + 1, invalid, sb);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> removeInvalidParentheses(String s) {
        int depth = 0;
        int invalid = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') depth++;
            else if (s.charAt(i) == ')') {
                depth--;
                if (depth < 0) {
                    invalid++;
                    depth = 0;
                }
            }
        }
        invalid += depth;
        helper(s, 0, invalid, new StringBuilder());
        return new ArrayList<>(set);
    }
}