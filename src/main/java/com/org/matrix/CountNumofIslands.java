package com.org.matrix;

public class CountNumofIslands {
    public static int dx[] = {-1,0,1,0};
    public static int dy[] = {0,1,0,-1};

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static void dfs(int x, int y, int r, int c, char [][] grid, boolean [][] vis) {
        if(x<0 || x>=r || y<0 || y>=c || vis[x][y]==true || grid[x][y] == '0') return;
        vis[x][y]=true;
        for(int i=0;i<4;i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 &&nx<r &&ny>=0 &&ny<c && vis[nx][ny]==false && grid[x][y] == '1')
                dfs(nx,ny,r,c,grid,vis);
        }
    }

    private static int numIslands(char[][] g) {
        int r=g.length;
        int c=g[0].length;
        boolean[][] vis = new boolean[r+1][c+1];
        int ans=0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(g[i][j]=='1' && !vis[i][j]) {
                    dfs(i,j,r,c,g,vis);
                    ans++;
                }
            }
        }
        return ans;
    }
}
