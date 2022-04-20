// Link: https://leetcode.com/problems/min-cost-climbing-stairs/

// Solution: rec + memo + tabular + space optimise

class Solution {
    public int helper(int idx, int[] cost, int[] dp){
        if(idx == cost.length){
            return dp[idx] = 0;
        }
        
        if(dp[idx] != 0){
            return dp[idx];
        }
        
        int ans = cost[idx];
        
        int step1 = 0;
        
        if(idx+1<=cost.length){
            step1+=helper(idx+1, cost, dp);
        }
        
        int step2 = 0;
        
        if(idx+2<=cost.length){
            step2+=helper(idx+2, cost, dp);
        }
        
        return dp[idx] = ans + Math.min(step1, step2);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        //memoize
//         int[] dp = new int[cost.length + 1];
//         int start0 = helper(0, cost, dp);
//         int start1 = helper(1, cost, dp);
        
//         return Math.min(start0, start1);
        
        //tabular
//         int[] dp = new int[cost.length+1];
//         for(int idx = cost.length; idx>=0; idx--){
//             if(idx == cost.length){
//                 dp[idx] = 0;
//                 continue;
//             }
            
//             int ans = cost[idx];

//             int step1 = 0;

//             if(idx+1<=cost.length){
//                 step1+=dp[idx+1];
//             }

//             int step2 = 0;

//             if(idx+2<=cost.length){
//                 step2+=dp[idx+2];
//             }

//             dp[idx] = ans + Math.min(step1, step2);
//         }
        
//         return Math.min(dp[0], dp[1]);
        
        //space optimize
        int next1 = cost[cost.length - 2], next2 = cost[cost.length-1];
        for(int idx = cost.length-3; idx>=0; idx--){
            int minCost = cost[idx] + Math.min(next1, next2);
            next2 = next1;
            next1 = minCost;
        }
        
        return Math.min(next1, next2);
    }
}