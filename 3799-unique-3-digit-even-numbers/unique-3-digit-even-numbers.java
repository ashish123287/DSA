class Solution {
    public void generate(int[] digits, HashSet<Integer> set, int i, int n, boolean[] used){
        if(n > 99){
            if(n%2 == 0) set.add(n);
            return;
        }
        for(int j = 0; j < digits.length; j++){
            if(used[j]) continue;
            used[j] = true;
            generate(digits, set, j, n*10+digits[j], used);
            used[j] = false;
        }
    }
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < digits.length; i++){
            if(digits[i] == 0) continue;
            boolean[] used = new boolean[digits.length];
            used[i] = true;
            generate(digits, set, i, digits[i], used);
        }
        return set.size();
    }
}