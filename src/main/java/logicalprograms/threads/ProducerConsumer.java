package logicalprograms.threads;

import java.util.LinkedList;
import java.util.List;

class Producer implements Runnable {
    private List<Integer> sharedQueue;
    int maxSize = 2;
    public Producer() {}
    public Producer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i=1; i<10; i++) {
            try {
                produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.size() == maxSize) {
                System.out.println("Waiting consumer to consume");
                sharedQueue.wait();
            }
        }
        synchronized (sharedQueue) {
            System.out.println("Produced :: " + i);
            sharedQueue.add(i);
            Thread.sleep(1000);
            sharedQueue.notify();
        }
    }
}

class Consumer implements Runnable {
    private List<Integer> sharedQueue;
    public Consumer() {}
    public Consumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void consumer() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.size() == 0) {
                System.out.println("Waiting for producer to produce");
                sharedQueue.wait();
            }
        }
        synchronized (sharedQueue) {
            Thread.sleep(2000);
            System.out.println("Consumer :: " + sharedQueue.remove(0));
            sharedQueue.notify();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Integer> sharedQueue = new LinkedList<>();
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);
        Thread th1 = new Thread(producer, "Producer Thread");
        Thread th2 = new Thread(consumer, "Consumer Thread");
        th1.start();
        th2.start();
    }
}
