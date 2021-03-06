// Link: https://leetcode.com/problems/search-a-2d-matrix/

// SOLUTION: Binary Search

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //SINCE THE MATRIX IS SORTED, WE CAN USE BINARY SEARCH
        int r = 0;
        int c = matrix[0].length - 1;

        // ptr at first row and last column
        while (r < matrix.length && c >= 0) {
            // if target found then return true result or the row, col indices
            if (matrix[r][c] == target) {
                return true;
                // return new int[]{r, c}; //you can return the row, col also like this
            }
            
            if (target > matrix[r][c]) {
                // target lies on down side
                // discard this row and all others above it
                r++;
            } else {
                // target lies on the left side
                // discard this col and all others on left of it
                c--;
            }
        }
        return false;
        // return new int[]{-1, -1};
    }
}