class Solution {
    public boolean isPalindrome(String s){
        if(s.length() <= 0) return true;
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<List<String>>> dp = new ArrayList<>();

        for(int i = 0; i <= n; i++) dp.add(new ArrayList<>());

        dp.get(n).add(new ArrayList<>());

        for(int k = n-1; k >= 0; k--){
            int i = k;
            int j = k;
            while(j < n){
                if(isPalindrome(s.substring(i, j+1))){
                    
                    for (int l = 0; l < dp.get(j + 1).size(); l++) {
                        List<String> list = new ArrayList<>();

                        // Current palindrome
                        list.add(s.substring(i, j + 1));

                        // Copying remaining partition
                        for (int m = 0; m < dp.get(j + 1).get(l).size(); m++) {
                            list.add(dp.get(j + 1).get(l).get(m));
                        }
                        dp.get(i).add(list);
                    }
                }
                j++;
            }
        }
        return dp.get(0);
    }
}