class Solution {
    public void checkPalindrome(String s, int i, int j, int[] arr){
        int n = s.length();
        while(i >= 0 && j < n){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            else break;
        }
        if(j-i-1 > arr[1]-arr[0]+1){
            arr[0] = i+1;
            arr[1] = j-1;
        }
    }
    public String longestPalindrome(String s) {
        int[] arr = new int[2];    // stores the first and last index of possible palindromic substring
        for(int i = 0; i < s.length(); i++){
            checkPalindrome(s, i, i, arr); // palindrome formed of odd length and s[i] is the mid element
            checkPalindrome(s, i, i+1, arr); // palindrome formed of even length and s[i],s[i+1] is the mid element
        }
        return s.substring(arr[0], arr[1]+1);
    }
}