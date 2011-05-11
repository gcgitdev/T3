package thread;

public class ExtendsThread extends Thread {

	public static void main(String[] args) {
		ExtendsThread t1 = new ExtendsThread();
		ExtendsThread t2 = new ExtendsThread();

		// diff way to run it
		new Thread(t1, "thread_id_1").start();
		t2.setName("thread_id_2");
		t2.start();
	}

	public void run() {
		String threadId = Thread.currentThread().getName();

		for (int i = 0; i < 5; i++) {
			System.out.println(i + " print in thread:" + threadId);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Work ended in thread:" + threadId);
	}
}
