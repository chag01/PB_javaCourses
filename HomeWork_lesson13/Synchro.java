import java.io.PrintStream;

public class Synchro {

    public static void main(String[] args) {
        Resource resource = new Resource();

        for (int i = 1; i < 11; i++) {
            Thread thread = new Thread(new MyThread(resource));
            thread.setName("Thread-" + i);
            thread.start();
        }
    }
}


class Resource {
    int a;
    public int incrementA() {
        return a++;
    }
}

class MyThread implements Runnable {
    Resource resource;

    MyThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i < 3; i++) {
            synchronized (resource){
            PrintStream out = System.out;
            out.println(Thread.currentThread().getName() + " зашел в цикл for ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println(Thread.currentThread().getName() + " вышел из цикла for, и вернул число " + resource.incrementA());
            }
        }
    }
}


