// Link: https://leetcode.com/problems/reverse-vowels-of-a-string/

// Solution: 2 pointer technique

class Solution {
    //function to check for vowels(UPPER AND LOWER CASE)
    private boolean checkVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch == 'U');
    }
    
    
    public String reverseVowels(String s) {
        //convert char arr because of string immutability
        char[] chArr = s.toCharArray();
        
        //starting and ending pointer
        int i=0, j=chArr.length-1;
        
        //work till the pointers meet
        while(i<j){
            //move i ptr to right for consonants
            while(i<j && !checkVowel(chArr[i])){
                i++;
            }
            
            //move j ptr to right for vowels
            while(j>i && !checkVowel(chArr[j])){
                j--;
            }
            
            //if i and j meet that means there is only 1 vowel which does not need to be reversed
            if(i>=j) break;
            
            //reverse ith & jth characters which are vowels
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            
            //move i to 1 step right and j to 1 step left
            i++;
            j--;
        }
        
        //convert char arr to string and return the ans
        StringBuilder ans = new StringBuilder();
        for(char ch: chArr){
            ans.append(ch);
        }
        
        return ans.toString();
    }
}


// Using 2 pointer and jump statement: goto

class Solution {
    //function to check for vowels(UPPER AND LOWER CASE)
    private boolean checkVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch == 'U');
    }
    
    
    public String reverseVowels(String s) {
        //convert char arr because of string immutability
        char[] chArr = s.toCharArray();
        
        //starting and ending pointer
        int i=0, j=chArr.length-1;
        
        //jump statement: goto
        restart:
        
        //work till the pointers meet
        while(i<j){
            //move i ptr to right for consonants
            while(!checkVowel(chArr[i])){
                if(i<j) i++;
                //if i>=j then go back and restart the while loop with goto statement
                else break restart;
            }
            
            //move j ptr to right for vowels
            while(!checkVowel(chArr[j])){
                if(j>i) j--;
                //if j<=i then go back and restart the while loop with goto statement
                else break restart;
            }
            
            //reverse ith & jth characters which are vowels
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            
            //move i to 1 step right and j to 1 step left
            i++;
            j--;
        }
        
        //convert char arr to string and return the ans
        return new String(chArr);
    }
}