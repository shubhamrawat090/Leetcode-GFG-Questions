// Link:

// Solution

// BRUTE FORCE: TLE
// Time: O(N^2), Space: O(N)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0]-b[0]);
        
        int[] dp = new int[envelopes.length];
        int maxlen=1;
        dp[0] = 1;
        
        for(int i=1;i<dp.length;i++){
            dp[i] = 1;
            
            for(int j=0;j<i;j++){
                if(envelopes[i][0]!=envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            
            maxlen = Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }
}

// Using BINARY SEARCH - Finding height idx or the nearest greater value
// Time: O(NlogN) Space: O(N)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        int[] dp = new int[envelopes.length];
        int maxlen=0;
        
        for(int i=0;i<dp.length;i++){
            
            //find the index of height of envelope[i]
            int index = binarySearch ( dp, 0, maxlen, envelopes[i][1]);
            
            dp[index] = envelopes[i][1];
            
            if(index == maxlen){
                maxlen++;
            }
            
        }
        return maxlen;
    }
    
    int binarySearch(int[] arr , int start, int end, int target){
        while(start<end){
            int mid= start + (end - start)/2;
            
            if(arr[mid]==target){
                return mid;
            }
            
            else if(arr[mid]>target){
                end = mid;
            }
            else{
                start = mid +1 ;
            }
        }
        return start;
    }
}

//Using Binary Search (In-Built Java Function)
// O(NlogN) time, O(N) space
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        int[] dp = new int[envelopes.length];
        int maxlen=0;
        
        for(int i=0;i<dp.length;i++){
            
            //find the index of height of envelope[i]
            int index = binarySearch (dp, 0, maxlen, envelopes[i][1]);
            
            dp[index] = envelopes[i][1];
            
            if(index == maxlen){
                maxlen++;
            }
            
        }
        return maxlen;
    }
    
    int binarySearch(int[] arr , int start, int end, int target){
        //returns -ve if element is not present
        int index = Arrays.binarySearch(arr,start,end,target);
        //we convert -ve to +ve to get the nearest greater element
        if(index<0){
            index = -(index+1);
        }
        return index;
    }
}