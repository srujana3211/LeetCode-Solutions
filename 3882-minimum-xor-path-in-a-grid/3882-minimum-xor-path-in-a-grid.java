class Solution {
    public int helper(int[][] grid, int vis[][], int r, int c, int n, int m, int xor, int dp[][][]){
        xor = xor^grid[r][c];
        if(r==(n-1) && c == (m-1)){
            return xor;
        }
        if(dp[r][c][xor]!=-1) return dp[r][c][xor];
        vis[r][c] = 1;
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if((c+1)<m && vis[r][c+1]==0){
            right = helper(grid, vis, r, c+1, n, m, xor, dp);
        }
        if((r+1)<n && vis[r+1][c]==0){
            down = helper(grid, vis, r+1, c, n, m, xor, dp);
        }
        vis[r][c] = 0;
        dp[r][c][xor] = Math.min(right, down);
        return Math.min(right, down);
    }
    public int minCost(int[][] grid) {
        int max[] = new int[1];
        int n = grid.length, m = grid[0].length;
        int dp[][][] = new int[n][m][1024];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int vis[][] = new int[n][m];
        int i, j;
        int ans = helper(grid, vis, 0, 0, n, m, 0, dp);
        return ans;
    }
}