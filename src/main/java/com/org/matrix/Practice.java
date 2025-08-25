package com.org.matrix;

public class Practice {
    private static int dx[] = {-1,0,1,0};
    private static int dy[] = {0,1,0,-1};

    public static void main(String[] args) {
        int[][]  matrix = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        System.out.println(noOfIslands(matrix));
    }

    private static int noOfIslands(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
        boolean[][] vis = new boolean[r+1][c+1];
        int count = 0;
        for (int x=0; x<r; x++) {
            for (int y=0; y<c; y++) {
                if (matrix[x][y] == 1 && !vis[x][y]) {
                    dfs(x,y,r,c,matrix,vis);
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(int x, int y, int r, int c, int[][] matrix, boolean[][] vis) {
        if (x<0 || y<0 || x>=r || y>=c || vis[x][y] == true || matrix[x][y] == 0) return;
        vis[x][y] = true;
        for (int i=0;i<4;i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 &&nx<r &&ny>=0 &&ny<c && vis[nx][ny]==false && matrix[x][y] == 1)
                dfs(nx, ny, r, c, matrix, vis);
        }
    }

}
