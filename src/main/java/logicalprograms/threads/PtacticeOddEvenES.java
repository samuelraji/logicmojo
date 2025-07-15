package logicalprograms.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintEvenOdd {
    int n;
    int counter;

    public PrintEvenOdd() {}

    public PrintEvenOdd(int n) {
        this.n = n;
        this.counter = 1;
    }

    public synchronized void printOdd() throws InterruptedException {
        while (counter <= n) {
            while (counter%2 == 0) {
                wait();
            }
            if (counter <= n) {
                System.out.println("Thread 1 ::: " + counter);
                counter++;
                notify();
            }
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (counter <= n) {
            while (counter % 2 != 0) {
                wait();
            }
            if (counter <= n) {
                System.out.println("Thread 2 ::: " + counter);
                counter++;
                notify();
            }
        }
    }
}

public class PtacticeOddEvenES {

    public static void main(String[] args) {
        PrintEvenOdd obj = new PrintEvenOdd(10);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            try {
                obj.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                obj.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }


}
