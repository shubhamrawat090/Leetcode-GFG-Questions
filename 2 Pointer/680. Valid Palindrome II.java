// Link: https://leetcode.com/problems/valid-palindrome-ii/

// Solution: 2 Pointers

/* ALGORITHM

    * Maintain 2 Pointers : Start and End pointing to the first and last index of the string.
    * Now traverse a while loop until start < end.
    * If char pointed by both pointer is same than,
    * Increment start and Decrement end.
    * If character didn't match increment start and end ramins same and increase the cnt1, as we are skipping the character from starting.
    * cnt will keep the track of no of instances that didn't match.
    * Reinitialise the start and end pointers.
    * Now again use a while loop and this time if character not matched decrement end end & start reamains same and incerease cnt2, as we are skipping character from end
    * If cnt or cnt1 is greater than 1 i will break the loop for optimization so that no that no need to compare all string content.
    * also we can skipped only 1 character therfore break only when cnt > 1.
    * if cnt1 and cnt2 remains 0 that means string is already a palindrome.
    * if cnt1 and cnt2 is 1 this means one character is obstructing the string to be palindrome, therefore we will delete that char by skipping it as done in code.
    * skipping start once and skipping end once.
    * If cnt1 == cnt2 remains 0 or 1 then return true.
    * As deleting of one character will result in a palindrome.
*/

class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        int countSkipStart = 0;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                // keeping cnt of character that didn't match when skipping 1 char from start
                countSkipStart++;
                i++;
            }else{
                //s.charAt(i) == s.charAt(j)
                // if char matches increment start and decrement end
                i++;
                j--;
            }
            
            // for optimising code if cnt is greater than 1 
            // we will just break the loop as only one char can skipped/deleted.
            if(countSkipStart > 1) break;
        }
        
        //reinitialise the pointers
        i=0;
        j=s.length()-1;  
        int countSkipEnd = 0;
        
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                // keeping cnt of character that didn't match when skipping 1 char from end
                countSkipEnd++;
                j--;
            }else{
                //s.charAt(i) == s.charAt(j)
                // if char matches increment start and decrement end
                i++;
                j--;
            }
            
            // for optimising code if cnt is greater than 1 
            // we will just break the loop as only one char can skipped/deleted.
            if(countSkipEnd > 1) break;
        }
        
        if(countSkipStart == 1 || countSkipEnd == 1){
            //delete atmost 1 character to make palindrome
            return true;
        }
        
        if(countSkipStart == 0 || countSkipEnd == 0){
            //already palindrome
            return true;
        }
        
        //cannot make palindrome even after deleting 1 character
        return false;
    }
}