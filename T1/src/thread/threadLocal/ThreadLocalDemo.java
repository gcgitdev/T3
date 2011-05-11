package thread.threadLocal;

import java.util.Random;

public class ThreadLocalDemo implements Runnable {
	// Note here, even it is a static variable, every thread will have its own diff copy
	private final static ThreadLocal<Integer> localInteger = new ThreadLocal<Integer>();
	private final static ThreadLocal<String> localString = new ThreadLocal<String>();

	public static void main(String[] agrs) {
		ThreadLocalDemo td = new ThreadLocalDemo();
		Thread t1 = new Thread(td, "thread_a");
		Thread t2 = new Thread(td, "thread_b");
		t1.start();
		t2.start();
	}

	public void run() {
		accessStudent();
	}

	public void accessStudent() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");

		Integer intLocal = getLocalInteger();
		String strLocal = getLocalString();

		System.out.println("thread " + currentThreadName + " first read Integer is:\t" + intLocal);
		System.out.println("thread " + currentThreadName + " first read String is:\t" + strLocal);

		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		System.out.println("thread " + currentThreadName + " second read Integer is:\t" + intLocal);
		System.out.println("thread " + currentThreadName + " second read String is:\t" + strLocal);
	}

	protected Integer getLocalInteger() {
		Integer value = (Integer) localInteger.get();

		if (value == null) {
			Random random = new Random();
			value = random.nextInt(100);
			localInteger.set(value);
		}
		return value;
	}

	protected String getLocalString() {
		String value = (String) localString.get();

		if (value == null) {
			Random random = new Random();
			value = "string-of-" + String.valueOf(random.nextInt(100));
			localString.set(value);
		}
		return value;
	}
}