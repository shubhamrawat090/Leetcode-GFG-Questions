// Link: https://leetcode.com/problems/n-th-tribonacci-number/

// Solution: rec+memo+tabular+space optimize

class Solution { 
    public int tribonacci(int n) {
        //recursive
        // return rec(n);
        
        //memoized
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return memo(n, dp);
        
        //tabular
//         int[] dp = new int[n+1];
//         for(int i=0; i<=n; i++){
//             if(i == 0){
//                 dp[i] = 0;
//                 continue;
//             }

//             if(i == 1 || i == 2){
//                 dp[i] = 1;
//                 continue;
//             }

//             dp[i] = dp[i-1] + dp[i-2] + dp[i-3];      
//         }
        
//         return dp[n]; 
        
        //space optimized
        int first = 0, second = 1, third = 1;
        
        if(n==0){
            return first;
        }
        
        if(n==1){
            return second;
        }
        
        if(n==2){
            return third;
        }
        
        for(int i=3; i<=n; i++){
            int val = first + second + third;
            first = second;
            second = third; 
            third = val;
        }
        
        return third;
    }
    
    public int rec(int n){
        if(n == 0){
            return 0;
        }
        
        if(n == 1 || n == 2){
            return 1;
        }
        
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }
    
    public int memo(int n, int[] dp){
        if(n == 0){
            return dp[n] = 0;
        }
        
        if(n == 1 || n == 2){
            return dp[n] = 1;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        return dp[n] = memo(n-1, dp) + memo(n-2, dp) + memo(n-3, dp);
    }
}