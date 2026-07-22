class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> zeroes = new ArrayList<>();  // stores the length of contigous zeroes 
        int n = s.length();
        int ones = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                int count = 0;
                while(i < n && s.charAt(i) == '0'){
                    count++;
                    i++;
                }
                zeroes.add(count);
                i--;
            }
            else ones++;
        }
        int ans = 0;

        for(int i = 0; i < zeroes.size()-1; i++){
            ans = Math.max(ans, zeroes.get(i)+zeroes.get(i+1));
        }
        return ans+ones;
    }
}