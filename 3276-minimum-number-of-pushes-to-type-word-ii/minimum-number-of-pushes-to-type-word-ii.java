class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i = 0; i < word.length(); i++) freq[word.charAt(i)-'a']++;
        int pushes = 0;
        Arrays.sort(freq);
        for(int i = 0; i < 26; i++){
            if(i < 2) pushes += 4*freq[i];
            else if(i < 10) pushes += 3*freq[i];
            else if(i < 18) pushes += 2*freq[i];
            else pushes += freq[i];
        }
        return pushes;
    }
}