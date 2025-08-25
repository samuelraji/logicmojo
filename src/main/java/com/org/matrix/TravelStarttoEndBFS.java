package com.org.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class TravelStarttoEndBFS {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1, 0},
                          {0, 1, 0, 0},
                          {1, 0, 1, 0}};
        System.out.println(bfs(matrix));
    }

    private static int bfs(int[][] matrix) {
        if (matrix.length == 0) {
            return -1;
        }
        int[] dx = {-1,-1, 0, 1, 1, 1, 0,-1};
        int[] dy = { 0, 1, 1, 1, 0,-1,-1,-1};
        int r = matrix.length;
        int c = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int ans = 0;
        if (matrix[0][0] == 1) {
            return -1;
        }
        while(!q.isEmpty()) {
            int size = q.size();
            ans++;
            for (int i=0; i<size; i++) {
                int[] point = q.poll();
                int xx = point[0];
                int yy = point[1];
                if (xx == r-1 && yy==c-1) {
                    return ans;
                }
                for (int k=0; k<8; k++) {
                    int nx = xx + dx[k];
                    int ny = yy + dy[k];
                    if (nx<0 || nx>=r || ny<0 || ny>=c) {
                        continue;
                    }
                    if (matrix[nx][ny] == 1) {
                        continue;
                    }
                    q.add(new int[]{nx, ny});
                    matrix[nx][ny] = 1;
                }
            }
        }
        return -1;
    }
}
