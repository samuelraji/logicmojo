package logicalprograms.threads;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Waiting for the thread lock:");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1 notified");
        }
    }
}

class MyRunnable2 implements Runnable {
    private MyRunnable myRunnable;
    public MyRunnable2(MyRunnable myRunnable) {
        this.myRunnable = myRunnable;
    }
    @Override
    public void run() {
        synchronized (this.myRunnable) {
            System.out.println("Waiting for the thread lock");
            try {
                myRunnable.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 notified");
        }
    }
}

class MyRunnable3 implements Runnable {
    private MyRunnable myRunnable;
    public MyRunnable3(MyRunnable myRunnable) {
        this.myRunnable = myRunnable;
    }
    @Override
    public void run() {
        synchronized (myRunnable) {
            System.out.println("About to notify other threads");
            myRunnable.notifyAll();
            System.out.println("Waiting threads notified");
        }
    }
}

public class WaitNotifyNotifyall {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        MyRunnable2 myRunnable2 = new MyRunnable2(myRunnable);
        MyRunnable3 myRunnable3 = new MyRunnable3(myRunnable);

        Thread th1 = new Thread(myRunnable, "Thread-1");
        Thread th2 = new Thread(myRunnable2, "Thread-2");
        Thread th3 = new Thread(myRunnable3, "Thread-3");

        th1.start();
        th2.start();
        th3.start();
    }
}
