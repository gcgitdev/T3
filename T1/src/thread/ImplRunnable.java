package thread;

public class ImplRunnable implements Runnable {

    public static void main(String[] args) {
        ImplRunnable t = new ImplRunnable();

        // have to new a Thread to run it
        new Thread(t, "thread_id_1").start();
        new Thread(t, "thread_id_2").start();
    }

    public void run() {
        String threadId = Thread.currentThread().getName();

        for (int i = 0; i < 5; i++) {
            System.out.println(i + " print in thread: " + threadId);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Work ended in thread: " + threadId);
    }

}
