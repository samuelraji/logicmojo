package com.org.onHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// A class to store a heap node
class Node implements Comparable {
        // `value` stores the element
        private int value;
        // `i` stores the list number of the element
        private int i;
        // `index` stores the column number of the list from which
        // element was taken
        private int index;
        // Constructor
        public Node(int value,int i,int index) {
            this.value = value;
            this.i = i;
            this.index = index;
        }
        public int getValue(){
            return value;
        }
        public int getListNum(){
            return i;
        }
        public int getIndex(){
            return index;
        }
        public void setIndex(int index){
            this.index = index;
        }
        public void setValue(int value){
            this.value = value;
        }
        @Override
        public int compareTo(Object o) {
            Node node = (Node)o;
            return value - node.value;
        }
}

public class SortedListsMerging {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();;
        lists.add(Arrays.asList(10, 20, 30, 40));
        lists.add(Arrays.asList(15, 25, 35));
        lists.add(Arrays.asList(27, 29, 37, 48, 93));
        lists.add(Arrays.asList(32, 33));
        printSorted(lists);
    }
    public static void printSorted(List<List<Integer>> lists) {
        // create an empty min-heap
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        // push the first element of each list into the min-heap
        // along with the list number and their index in the list
        for(int i = 0;i<lists.size();i++) {
            if(lists.get(i).size()>= 1) {
                pq.add(new Node(lists.get(i).get(0),i,0));
            }
        }

        // run till min-heap is empty
        while(!pq.isEmpty()) {
            // extract the minimum node from the min-heap
            Node min = pq.poll();
            // print the minimum element
            System.out.print(min.getValue() + " ");
            // take the next element from the "same" list and insert it into the
            // min-heap
            if(min.getIndex() + 1 < lists.get(min.getListNum()).size()) {
                min.setIndex(min.getIndex() + 1);
                min.setValue(lists.get(min.getListNum()).get(min.getIndex()));
                pq.add(min);
            }
        }
    }
}
