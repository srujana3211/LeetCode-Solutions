class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length, i, j;
        int row[] = new int[n];
        int col[] = new int[m];
        int ans = 0;
        for(i=0; i<n; i++){
            for(j=0; j<m; j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for(i=0; i<n; i++){
            for(j=0; j<m; j++){
                if(grid[i][j]==1){
                    if(row[i]>1 || col[j]>1) ans++;
                }
            }
        }
        return ans;
    }
}