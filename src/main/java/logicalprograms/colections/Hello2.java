package logicalprograms.colections;

import java.util.Arrays;
import java.util.Collections;

public class Hello2 {

    public static void main(String[] args) {
        int arr[]={10,23,10,53,20,21,30};

        Arrays.sort(arr);

        for (int k=arr.length-1; k>0; k--) {
            int i=0, j= arr.length-1;
            while (i<j) {
                if (arr[i]+arr[j] == arr[k]) {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    break;
                } else if (arr[i]+arr[j] < arr[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
    }

}
