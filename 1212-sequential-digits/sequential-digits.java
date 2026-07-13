class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < 9; i++){
            int digit = i;
            for(int j = i+1; j < 10; j++){
                digit = digit*10 + j;
                if(digit > high) break;
                else if(digit < low) continue;
                result.add(digit);
            }
        }
        Collections.sort(result);
        return result;
    }
}