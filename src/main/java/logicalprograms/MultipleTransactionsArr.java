package logicalprograms;

// moor floating algorithm

public class MultipleTransactionsArr {
    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 3, 7, 6, 4, 5};
        int profit = 0;
        int buy = arr[0];
        for (int i=1;i<arr.length;) {
            if (i > arr.length) {
                break;
            }
            if (buy-arr[i] > buy-arr[i+1]) {
                profit = profit + (buy-arr[i]);
                buy = arr[i+1];
                i = i+2;
            } else if (buy-arr[i] < buy-arr[i+1]) {
                profit = profit + (buy-arr[i+1]);
                buy = arr[i+2];
                i = i+3;
            }
        }
        System.out.println(" PROFIT :: " + profit);
    }
}
