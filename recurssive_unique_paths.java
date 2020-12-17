// Time Complexity : O(2^m*n), where m and n are the number of rows and columns in the grid
// Space Complexity :O(m*n),  where m and n are the number of rows and columns in the grid (recurssive stack space)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

//Three liner explanation of your code in plain english
//1. Create a grid of size m*n and start the dfs from first cell, moving either right OR bottom (create a dirs array for that)
//2. If you reach the last cell (bottom right), increment the path counter and return
//3. keep doing this all the paths are explored

// Your code here along with comments explaining your approach

class Solution {
    //to keep count of all unique paths
    int paths;
    //dirs array
    int[][] dirs = {{0, 1}, {1, 0}};
    public int uniquePaths(int m, int n) {
        //create the m*n grid
        int[][] grid = new int[m][n];
        //direction to go right and down 
        //dirs = new int{{0, 1}, {1, 0}};
        paths = 0;
        //start dfs from top left corner
        dfs(0, 0, m, n);
        return paths;
    }
    
    private void dfs(int i, int j, int m , int n){
        //base
        //when you reach the bottom right, record the path and continue find the rest of the unique paths
        if(i == m-1 && j == n-1){
            paths++;
            return;
        }
        //boundry conditions
        if(i == m || j == n) return;
        //logic
        //from each cell, first explore the right path then the bottom path
        for(int[] dir: dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            //call dfs from the newly moved cell
            dfs(row, col, m, n);
        }
    }
}