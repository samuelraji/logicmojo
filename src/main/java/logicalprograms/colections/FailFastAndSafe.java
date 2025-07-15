package logicalprograms.colections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FailFastAndSafe {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String val = it.next();
            if (val.equals("A")) {
                it.set("X");
                it.add("Y");
                //list.add("C");
            }
        }
        System.out.println(list);  // Output: [X, Y, B]
    }
}
