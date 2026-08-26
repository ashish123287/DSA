class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1') list.add(i);
        } 
        if(list.size() < k) return "";
        if(list.size() == k) return s.substring(list.get(0), list.get(k-1)+1);
        int min = 101;
        for(int i = k-1; i < list.size(); i++) min = Math.min(min, list.get(i)-list.get(i-k+1)+1);
        List<String> arr = new ArrayList<>();
        for(int i = k-1; i < list.size(); i++){
            if(list.get(i)-list.get(i-k+1)+1 > min) continue;
            arr.add(s.substring(list.get(i-k+1), list.get(i)+1));
        } 
        Collections.sort(arr);
        return arr.get(0);
    }
}