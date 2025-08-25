package com.org.onStack;

import java.util.*;

class Interval {
    int begin;
    int end;

    public Interval(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
public class NonOverlapTimeIntervals {
    // {1, 5}, {2, 3}, {4, 6}, {7, 8}, {8, 10}, {12, 15}
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(1,5), new Interval(2,3), new Interval(4,6), new Interval(7,8),
                new Interval(8,10),new Interval(12,15)));
        Collections.sort(intervals, Comparator.comparingInt(interval-> interval.begin));
        Stack<Interval> stack = new Stack<>();
        for (Interval curr: intervals) {
            if(stack.empty() || curr.begin>stack.peek().end){
                stack.push(curr);
            }
            if(stack.peek().end<curr.end){
                stack.peek().end = curr.end;
            }
        }
        System.out.println(stack);
    }
}
