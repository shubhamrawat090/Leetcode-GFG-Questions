// Link: https://leetcode.com/problems/add-binary/

// SOLUTION

// EXPLANATION IN-DEPTH : https://leetcode.com/problems/add-binary/discuss/1679423/Well-Detailed-Explaination-Java-C%2B%2B-Python-oror-Easy-for-mind-to-Accept-it

class Solution {
    public String addBinary(String a, String b) {
        //calculating result
        StringBuilder res = new StringBuilder();
        
        //keep two pointers at end of both string
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        //contains carry generated by adding 2 values
        int carry = 0;
        
        //traverse both the strings from reverse till both of them finishes
        while(i >= 0 || j >= 0){
            //add carry generated by previous digits' addition to sum
            int sum = carry;
            
            //if string a has any no. left then add it's integer value to sum, and same for string b
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            
            // In Binary 1+0 = 1, 0+0 = 1, 1+1=11(2 in decimal), so a carry of 1 is taken if sum>1
            carry = sum > 1 ? 1 : 0;
            
            // last digit of sum is added to ans
            res.append(sum % 2);
        }
        
        //if there is a carry left just add it to the ans
        if(carry != 0) res.append(carry);
        
        //we have got our ans in reverse-order just reverse it again and return it
        return res.reverse().toString();
    }
}