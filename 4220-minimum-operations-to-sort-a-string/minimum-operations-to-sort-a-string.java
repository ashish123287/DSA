class Solution {
    public int minOperations(String s) {
        if(s.length() == 2){
            if(s.charAt(0) > s.charAt(1)) return -1;
            else return 0;
        }
        int smallest = 0;
        int largest = s.length()-1;
        boolean check = false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch < s.charAt(smallest)) smallest = i;
            if(ch >= s.charAt(largest)) largest = i;
            if(i > 0){
                if(ch < s.charAt(i-1)) check = true; 
            }
        }
        if(!check) return 0;
        if(0 == largest && s.length()-1 == smallest) return 3;
        if(0 == smallest || s.length()-1 == largest) return 1;
        return 2;
    }
}