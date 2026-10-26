class Solution {
    public void dfs(int r, int c, int n, int m, int grid[][], int vis[][], int delrow[], int delcol[], long count[]){
        int i; 
        vis[r][c] = 1;
        count[0] += grid[r][c];
        for(i=0; i<4; i++){
            int nr = r+delrow[i];
            int nc = c+delcol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]!=0){
                dfs(nr, nc, n, m, grid, vis, delrow, delcol, count);
            }
        }
        return;
    }
    public int countIslands(int[][] grid, int k) {
        int i, j, n = grid.length, m = grid[0].length;
        int ans = 0;
        int vis[][] = new int[n][m];
        int delrow[] = {0, +1, 0, -1};
        int delcol[] = {+1, 0, -1, 0};
        long count[] = new long[1];
        for(i=0; i<n; i++){
            for(j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]!=0){
                    count[0] = 0;
                    dfs(i, j, n, m, grid, vis, delrow, delcol, count);
                    if(count[0]%k==0) ans++;
                }
            }
        }
        return ans;
    }
}