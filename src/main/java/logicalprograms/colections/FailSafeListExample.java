package logicalprograms.colections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class FailSafeListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            list.add("C");
        }

        System.out.println("Final list: " + list);
    }
}