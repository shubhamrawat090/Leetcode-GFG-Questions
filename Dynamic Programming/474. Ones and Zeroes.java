// Link:

// Solution

// rec+memo+tab

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length+1];
        // for(int[][] row: dp) {
        //     for(int[] col: row) {
        //         Arrays.fill(col, -1);
        //     }
        // }
        
        int ans = tabulation(strs, m, n, dp);
        return ans;
    }
    
    //Tabulation
    private int tabulation(String[] strs, int zeroes, int ones, int[][][] dp) {
        int size = strs.length;
        for(int index = 0; index <= size; index++){
           for(int m = 0; m <= zeroes; m++){
               for(int n = 0; n <= ones; n++){
                   //BASE CASE
                   if(index == 0) {
                       dp[m][n][index] = 0;
                       continue;
                   }
                   
                   //exclude idx-1
                   int exc = dp[m][n][index - 1]; 

                   //include idx-1
                   int[] count = getCount(strs[index - 1]);
                   int inc = 0;
                   if (count[0] <= m && count[1] <= n) 
                       inc = 1 + dp[m - count[0]][n - count[1]][index - 1];
                   
                    dp[m][n][index] = Math.max(exc, inc);
               }
           }
       }
       return dp[zeroes][ones][size];
    }
    
    //Memoized
    private int memo(String[] strs, int m, int n, int idx, int[][][] dp) {
        if(idx == strs.length) return dp[m][n][idx] = 0;
        
        if(dp[m][n][idx] != -1) return dp[m][n][idx];
        
        //exclude curr value
        int exc = memo(strs, m, n, idx+1, dp);
        
        //include curr value
        int[] count = getCount(strs[idx]);
        int inc = 0;
        
        //if curr values count of 0's and 1's matches the condition, then count it in ans
        if(count[0]<=m && count[1]<=n) {
            inc = 1 + memo(strs, m-count[0], n-count[1], idx+1, dp);
        }
        
        return dp[m][n][idx] = Math.max(inc, exc); 
    }
    
    //Recursive : Gives TLE
    private int rec(String[] strs, int m, int n, int idx) {
        if(idx == strs.length) return 0;
        
        //exclude curr value
        int exc = rec(strs, m, n, idx+1);
        
        //include curr value
        int[] count = getCount(strs[idx]);
        int inc = 0;
        
        //if curr values count of 0's and 1's matches the condition, then count it in ans
        if(count[0]<=m && count[1]<=n) {
            inc = 1 + rec(strs, m-count[0], n-count[1], idx+1);
        }
        
        return Math.max(inc, exc); 
    }
    
    private int[] getCount(String str) {
        int zero = 0, one = 0;

        for(char c: str.toCharArray()) {
            if(c=='0') zero++;
            else one++;
        }
        
        return new int[]{zero, one};
    }
}


// ALTERNATE DP APPROACH

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int ones=0;
        int zeros=0;
        int[] count = new int[2];
        for(String str: strs){
            //get zeroes and ones count
            count01(str, count);
            zeros = count[0];
            ones = count[1];
            for(int i=m;i>=zeros;i--){
                for(int j=n;j>=ones;j--){
                   dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
            
        }
        return dp[m][n];
        
    }
    
    public void count01(String s, int[] count) {
        int z = 0, o = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1')
                    o++;
                else
                    z++;
        }
        count[0] = z;
        count[1] = o;
    } 
    
}