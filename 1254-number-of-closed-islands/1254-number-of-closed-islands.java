class Solution {
    public void dfs(int r, int c, int n, int m, int grid[][], int vis[][], int delrow[], int delcol[]){
        int i; 
        vis[r][c] = 1;
        for(i=0; i<4; i++){
            int nr = r+delrow[i];
            int nc = c+delcol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==0){
                dfs(nr, nc, n, m, grid, vis, delrow, delcol);
            }
        }
        return;
    }
    public int closedIsland(int[][] grid) {
        int i, j, n = grid.length, m = grid[0].length;
        int ans = 0;
        int vis[][] = new int[n][m];
        int delrow[] = {0, +1, 0, -1};
        int delcol[] = {+1, 0, -1, 0};
        for(i=0; i<n; i++){
            if(vis[i][0]!=1 && grid[i][0]==0){
                dfs(i, 0, n, m, grid, vis, delrow, delcol);
            }
            if(vis[i][m-1]!=1 && grid[i][m-1]==0){
                dfs(i, m-1, n, m, grid, vis, delrow, delcol);
            }
        }
        for(i=0; i<m; i++){
            if(vis[0][i]!=1 && grid[0][i]==0){
                dfs(0, i, n, m, grid, vis, delrow, delcol);
            }
            if(vis[n-1][i]!=1 && grid[n-1][i]==0){
                dfs(n-1, i, n, m, grid, vis, delrow, delcol);
            }
        }
        for(i=0; i<n; i++){
            for(j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==0){
                    ans++;
                    dfs(i, j, n, m, grid, vis, delrow, delcol);
                }
            }
        }
        return ans;
    }
}