package logicalprograms.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ABC {
    int start = 1;
    int max = 10;

    public synchronized void printOddNum() throws InterruptedException {
        while(start < max) {
            if (start %2 == 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " :: " + start);
            start++;
            notify();
        }
    }

    public synchronized void printEvenNum() throws InterruptedException {
        while (start < max) {
            if (start % 2 != 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " :: " + start);
            start++;
            notify();
        }
    }
}

public class Practice {

    public static void main(String[] args) {

        /** Using normal 2 threads*/
        ABC abc = new ABC();
        Thread th1 = new Thread(()->{
            try {abc.printOddNum();} catch (InterruptedException e) {throw new RuntimeException(e);}
        });
        Thread th2 = new Thread(()->{
            try { abc.printEvenNum();} catch (InterruptedException e) {throw new RuntimeException(e);}
        });
        //th1.start();
        //th2.start();
        /** Using executor service */
        ExecutorService es = Executors.newFixedThreadPool(2);

        /*es.execute(()->{
            try {
                abc.printOddNum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        es.execute(()->{
            try {
                abc.printEvenNum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        */

        /** using completablefuture */

        CompletableFuture future1 = CompletableFuture.runAsync(()->{
            try {
                abc.printOddNum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, es).thenRun(() -> {
            System.out.println("Done 1");
        });

        CompletableFuture future2 = CompletableFuture.runAsync(()->{
            try {
                abc.printEvenNum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, es).thenRun(() -> {
            System.out.println("Done 2");
        });

        future1.join();

        System.out.println("Tasks started to execute");
        // Wait for both to complete
        CompletableFuture<Void> combined = CompletableFuture.allOf(future1, future2);

        // Optional: run something after both complete
        combined.thenRun(() -> {
           System.out.println("Both runAsync tasks finished!");
        });

        //Block main thread until all tasks complete
        combined.join();
        es.shutdown();

    }

}
