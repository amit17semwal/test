import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestThread {

	public static void main(
			String[] args) {/*
							 * Run1 r1 = new Run1(); Run1 r2 = new Run1();
							 * Thread t1 = new Thread(r1); // Thread t2 = new
							 * Thread(new Run1()); t1.start(); // t2.start();
							 * System.out.println("Hello"); r1.setNull(t1); t1 =
							 * null; System.out.println("Hello2"); System.gc();
							 * 
							 * try { File file = new File("abc");
							 * file.getCanonicalFile(); } catch (IOException e)
							 * { }
							 * 
							 */

		// creating two threads
		ThreadJoining t1 = new ThreadJoining();
		ThreadJoining t2 = new ThreadJoining();
		ThreadJoining t3 = new ThreadJoining();

		// thread t1 starts
		t1.start();

		// starts second thread after when
		// first thread t1 is died.
		try {
			System.out.println("Current Thread: " + Thread.currentThread().getName());
			t1.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has " + "been caught" + ex);
		}

		// t2 starts
		t2.start();

		// starts t3 after when thread t2 is died.
		try {
			System.out.println("Current Thread: " + Thread.currentThread().getName());
			t2.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has been" + " caught" + ex);
		}

		t3.start();

	}

	public void show(int j) {
		int i;
		if (j == 0) {
			i = j;
			System.out.println(i);
		}
	}

}

class Dummy {
	final int a;
	final String b;

	public Dummy() {
		a = 4;
		b = "Amit";
	}
}

class Run1 implements Runnable {

	@Override
	public void run() {
		int i = 10;
		while (i > 1) {
			System.out.println(" This is " + Thread.currentThread());
			i--;
		}
	}

	public void display() {
		System.out.println("Display method");
		try {
			wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setNull(Thread t) {
		t = null;
	}
}

class ThreadJoining extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(500);
				System.out.println("Current Thread: " + Thread.currentThread().getName());
			}

			catch (Exception ex) {
				System.out.println("Exception has" + " been caught" + ex);
			}
			System.out.println(i);
		}
	}
}