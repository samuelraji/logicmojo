package logicalprograms.threads;

import java.util.concurrent.CompletableFuture;

class ThreadLogic {
    private final int n;
    int start =1;
    public ThreadLogic(int n) {
        this.n = n;
    }

    public synchronized void printEven() throws InterruptedException {
        while (start < n) {
            while (start%2 != 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " :: "+ start);
            start++;
            notify();
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (start < n) {
            while (start%2 == 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " :: "+ start);
            start++;
            notify();
        }
    }
}

public class MyLogic {

    public static void main(String[] args) {
        int n = 10;
        ThreadLogic logicObj = new ThreadLogic(n);

        /*Thread th1 = new Thread(()->{
            try {
                logicObj.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread th2 = new Thread(()->{
            try {
                logicObj.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        th1.start();
        th2.start();*/

        //ExecutorService es = Executors.newFixedThreadPool(2);

        /*es.execute(()->{
            try {
                logicObj.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        es.execute(()->{
            try {
                logicObj.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

        //es.shutdown();

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            try {
                logicObj.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).thenRun(() -> {
            System.out.println("DONE 1");
        });

        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            try {
                logicObj.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).thenRun(() -> {
            System.out.println("DONE 2");
        });

        task1.join();
        System.out.println("Tasks started to execute");
        // Wait for both to complete
        //CompletableFuture<Void> combined = CompletableFuture.allOf(task1, task2);

        // Optional: run something after both complete
        //combined.thenRun(() -> {
        //   System.out.println("Both runAsync tasks finished!");
        //});

        // Block main thread until all tasks complete
        //combined.join();
    }
}
