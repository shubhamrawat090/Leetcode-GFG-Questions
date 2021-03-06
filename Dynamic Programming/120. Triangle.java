// Link: https://leetcode.com/problems/triangle/

// Solution: 

// TABULATION 1-D DP
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null) 
            return 0;
        
        int size = triangle.size(); 
        
        int[] dp = new int[size+1];
        
        dfs(dp,triangle,size-1);
        
        return dp[0];
        
    }
    
    private void dfs(int[] dp,List<List<Integer>> t,int row){
        if(row<0) 
            return;
        
        for(int j=0;j<=row;j++){
            dp[j] = t.get(row).get(j) + Math.min(dp[j], dp[j+1]);
        } 
        
        dfs(dp, t, row-1);
    }
}

// Recursion + Memoization + Tabulation(2 ways)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return rec(triangle, 0, 0);
        int[][] dp = new int[200][200];
//         for(int[] a: dp) {
//             Arrays.fill(a, -1);
//         }
        
//         return memo(triangle, 0, 0, dp);
        
        // return tab(triangle);
        return tab(triangle, dp);
    }
    
    //TABULATION
    private int tab(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for (int i = triangle.size()-1; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                int min = triangle.get(i).get(j);
                //FOR LAST ROW CURR (i,j) val is the only answer
                if (i < triangle.size() - 1)
                    min += Math.min(dp[i+1][j], dp[i+1][j+1]);
                
                dp[i][j] = min;
            }
        }
        
        return dp[0][0];
    }
    
    //TABULATION VERSION 2
    private int tab(List<List<Integer>> triangle, int[][] dp) {
        for(int r=triangle.size()-1; r>=0; r--) {
            for(int c=triangle.get(r).size()-1; c>=0; c--) {
                if(r==triangle.size()-1) {
                    dp[r][c] = triangle.get(r).get(c);
                    continue;
                }

                int same = triangle.get(r).get(c);
                same += dp[r+1][c];

                int next = triangle.get(r).get(c);
                next += dp[r+1][c+1];

                dp[r][c] = Math.min(same, next);
            }
        }
        
        return dp[0][0];
    }
    
    //MEMOIZED
    private int memo(List<List<Integer>> triangle, int r, int c, int[][] dp) {
        if(r==triangle.size()) {
            return dp[r][c] = 0;
        }
        
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        
        int same = triangle.get(r).get(c);
        same += memo(triangle, r+1, c, dp);
        
        int next = triangle.get(r).get(c);
        next += memo(triangle, r+1, c+1, dp);
        
        return dp[r][c] = Math.min(same, next);
    }
    
    //RECURSIVE
    private int rec(List<List<Integer>> triangle, int r, int c) {
        if(r==triangle.size()) {
            return 0;
        }
        
        int same = triangle.get(r).get(c);
        same += rec(triangle, r+1, c);
        
        int next = triangle.get(r).get(c);
        next += rec(triangle, r+1, c+1);
        
        return Math.min(same, next);
    }
    
}