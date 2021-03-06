// Link: https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/

// Solution

//Frequency Array
class Solution {
    public boolean digitCount(String num) {
        //10 is the limit in constraints
        int[] freq = new int[10];
        
        //get freq of all digits
        for(int i=0; i<num.length(); i++) {
            freq[num.charAt(i)-'0']++;
        }
        
        //match it according to question
        for(int i=0; i<num.length(); i++) {
           if(freq[i]!=num.charAt(i)-'0')
               return false;
        }
        
        return true;
    }
}

// Hashmap

class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i=0; i<n; i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            if(!map.containsKey(digit)) {
                map.put(digit, 1);
            } else {
                map.put(digit, map.get(digit)+1);
            }  
        }
        
        for(int i=0; i<n; i++) {
            if(!map.containsKey(i))
                map.put(i,0);
        }
        
        for(int key: map.keySet()) {
            int digit = Character.getNumericValue(num.charAt(key));
            int mapFreq = map.get(key);
            if(digit!=mapFreq) return false;
        }
        
        return true;
    }
}