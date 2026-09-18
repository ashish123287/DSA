class Solution { 
    public List<String> maxNumOfSubstrings(String s) { 
        int[][] arr = new int[26][2]; 

        for(int i = 0; i < 26; i++){ 
            arr[i][0] = -1; 
            arr[i][1] = -1; 
        } 

        for(int i = 0; i < s.length(); i++){ 
            char ch = s.charAt(i); 

            if(arr[ch - 'a'][0] == -1){ 
                arr[ch - 'a'][0] = i; 
            } 

            arr[ch - 'a'][1] = i; 
        } 

        int[][] original = new int[26][2]; 

        for(int i = 0; i < 26; i++){ 
            original[i][0] = arr[i][0]; 
            original[i][1] = arr[i][1]; 
        } 

        // Expand the intervals
        for(int i = 0; i < 26; i++){ 
            if(original[i][0] == -1) continue; 

            int left = original[i][0]; 
            int right = original[i][1]; 
            boolean valid = true; 

            for(int j = left; j <= right; j++){ 
                int ch = s.charAt(j) - 'a'; 

                if(original[ch][0] < left){ 
                    valid = false; 
                    break; 
                } 

                right = Math.max(right, original[ch][1]); 
            } 

            if(valid){ 
                arr[i][0] = left; 
                arr[i][1] = right; 
            } 
            else{ 
                arr[i][0] = -1; 
                arr[i][1] = -1; 
            } 
        } 

        // Activity Selection - sort according to end index
        Arrays.sort(arr, (a, b) -> { 
            if(a[0] == -1) return 1; 
            if(b[0] == -1) return -1; 
            return a[1] - b[1]; 
        }); 

        List<String> result = new ArrayList<>(); 
        int pre = -1; 

        for(int i = 0; i < 26; i++){ 
            if(arr[i][0] == -1) continue; 

            if(pre < arr[i][0]){ 
                result.add(
                    s.substring(arr[i][0], arr[i][1] + 1)
                ); 
                pre = arr[i][1]; 
            } 
        } 

        return result; 
    } 
}