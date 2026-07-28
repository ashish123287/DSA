class Solution {
    public String smallestPalindrome(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++) arr[s.charAt(i)-'a']++;
        int odd = -1;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < 26; i++){
            if(arr[i]%2 == 1) odd = i;
            arr[i] = arr[i]/2;
            char ch = (char)('a'+i);
            while(arr[i] > 0){
                sb.append(ch);
                arr[i]--;
            }
        }
        StringBuilder rev = new StringBuilder(sb).reverse();
        if(odd != -1) sb.append((char)('a'+odd));
        sb.append(rev);
        return sb.toString();
    }
}