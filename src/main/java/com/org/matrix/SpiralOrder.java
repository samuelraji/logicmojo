package com.org.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] mat = {{10,20,30,40},
                       {15,25,35,45},
                       {27,29,37,48},
                       {32,33,39,50}};

        List<Integer> list = spiralOrder(mat);
        list.forEach(ele -> System.out.print(ele+" "));
    }

    public static List<Integer> spiralOrder(int mat[][]) {
        List<Integer> result = new ArrayList<>();
        if (mat.length == 0 || mat[0].length == 0) return result;
        int left = 0;
        int top = 0;
        int bottom = mat.length-1;
        int right = mat[0].length-1;
        while(true) {
            for(int i = left; i<= right; i++) result.add(mat[top][i]);
            top++;
            if(left > right || top > bottom) break;
            for(int i = top; i<= bottom; i++) result.add(mat[i][right]);
            right--;
            if(left > right || top > bottom) break;
            for(int i = right; i>= left; i--) result.add(mat[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;
            for(int i = bottom; i>= top; i--) result.add(mat[i][left]);
            left++;
            if(left > right || top > bottom) break;
        }
        return result;
    }
}
