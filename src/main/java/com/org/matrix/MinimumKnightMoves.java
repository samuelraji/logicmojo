package com.org.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
    public static void main(String[] args) {
        int x=1, y=1;
        System.out.println(minKnightMoves(x, y));
    }

    private static int minKnightMoves(int x, int y) {
        if (x==0 && y==0) {
            return 0;
        }
        int dx[] = {2, 2,-2,-2, 1,-1, 1,-1};
        int dy[] = {1,-1, 1,-1, 2,-2,-2, 2};
        x=Math.abs(x);
        y=Math.abs(y);
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[301][301];
        vis[0][0]=true;
        q.add(new int[]{0, 0});
        int l = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            l++;
            for (int i=0; i<size; i++) {
                int[] point = q.poll();
                int xx = point[0];
                int yy = point[1];
                if (xx == x && yy == y) {
                    return l-1;
                }
                for (int k=0; k<8; k++) {
                    int nx = Math.abs(xx+dx[k]);
                    int ny = Math.abs(yy+dy[k]);
                    if (nx >= 0 && ny >= 0 && nx<301 && ny<301) {
                        if (vis[nx][ny] == false) {
                            vis[nx][ny]=true;
                            q.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

}
