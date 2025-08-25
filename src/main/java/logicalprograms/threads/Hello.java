package logicalprograms.threads;

public class Hello {

    private int n;
    int start=1;
    Hello(int n) {
        this.n = n;
    }

    public synchronized void printOddNums() throws InterruptedException {
        while (start < n) {
            while (start%2 == 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " :: "+ start);
            start++;
            notify();
        }
    }

    public synchronized void printEvenNums() throws InterruptedException {
        while (start < n) {
            if (start%2 != 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " :: "+ start);
            start++;
            notify();
        }
    }

    public static void main(String[] args) {
        Hello hello = new Hello(10);
        Thread th1 = new Thread(()->{
            try {
                hello.printOddNums();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread th2 = new Thread(()->{
            try {
                hello.printEvenNums();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        th1.run();
        th2.run();
    }
}
