package com.org.matrix;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][]  matrix = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(matrix));
    }

    public static int dfs(int x,int y, int r, int c, int[][] g, boolean[][] vis) {
        if(x<0 || y<0 || x>=r || y>=c || g[x][y]==0 || vis[x][y]==true)
            return 0;
        vis[x][y]=true;
        return 1 + dfs(x+1,y,r,c,g,vis) + dfs(x,y+1,r,c,g,vis) + dfs(x-1,y,r,c,g,vis) + dfs(x,y-1,r,c,g,vis);
    }

    public static int maxAreaOfIsland(int[][] g) {
        int r = g.length;
        int c = g[0].length;
        int ans=0;
        boolean[][] vis = new boolean[r+1][c+1];
        int cnt=0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(g[i][j]==1 && vis[i][j]==false) {
                    cnt = dfs(i,j,r,c,g,vis);
                    if(cnt>ans)
                        ans=cnt;
                }
            }
        }
        return ans;
    }
}
