import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            Thread producer = new Thread(new Producer(list));
            producer.setName("Producer-" + i);
            producer.start();
        }

        Thread consumer = new Thread(new Consumer(list));
        consumer.setName("Consumer");
        consumer.start();
    }
}


class Producer implements Runnable {
    private List<Integer> list;
    private int randomInt;
    private int listMaxSize = 1;

    public Producer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                while (list.size() == listMaxSize) {
                    System.out.println(Thread.currentThread().getName() + " - контейнер заполнен. Ожидание выгрузки");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                randomInt = random.nextInt(100);
                System.out.println(Thread.currentThread().getName() + " поместил в контейнер число: " + randomInt);
                list.add(randomInt);
                list.notifyAll();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Consumer implements Runnable {
    private List<Integer> list;

    Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    for (Integer x : list) {
                        System.out.println(Thread.currentThread().getName() + " - Вывод числа из контейнера: " + x);
                    }
                    list.removeAll(list);
                    list.notifyAll();
                }
            }
        }
    }
}

