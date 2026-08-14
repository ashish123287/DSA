class Solution {
    public int maximumLengthSubstring(String s) {
        int low = 0;
        int ans = 1;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            if(freq[ch-'a'] > 2) {
                while(s.charAt(low) != ch){
                    freq[s.charAt(low)-'a']--;
                    low++;
                }
                freq[s.charAt(low)-'a']--;
                low++;
            }
            ans = Math.max(i-low+1, ans);
        }
        return ans;
    }
}