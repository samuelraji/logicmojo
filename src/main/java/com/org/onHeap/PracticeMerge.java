package com.org.onHeap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class NNN implements Comparable {
    private int num;
    private int row;
    private int col;


    public NNN(int num, int row, int col) {
        this.num = num;
        this.row = row;
        this.col = col;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int compareTo(Object o) {
        NNN nn = (NNN)o;
        return this.num - nn.num;
    }
}

public class PracticeMerge {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();;
        lists.add(Arrays.asList(10, 20, 30, 40));
        lists.add(Arrays.asList(15, 25, 35));
        lists.add(Arrays.asList(27, 29, 37, 48, 93));
        lists.add(Arrays.asList(32, 33));
        printWhileSorting(lists);
    }

    private static void printWhileSorting(List<List<Integer>> lists) {
        PriorityQueue<NNN> pq = new PriorityQueue<>();
        for (int i=0; i< lists.size();i++) {
            pq.add(new NNN(lists.get(i).get(0), i, 0));
        }
        while (!pq.isEmpty()) {
            NNN nn = pq.poll();
            System.out.print(nn.getNum() + " ");
            int nextCol = nn.getCol() + 1;
            int row = nn.getRow();
            if (nextCol < lists.get(row).size()) {
                //pq.add(new NNN(lists.get(row).get(nextCol), row, nextCol));
                nn.setNum(lists.get(row).get(nextCol));
                nn.setCol(nextCol);
                pq.add(nn);
            }
        }
    }
}
