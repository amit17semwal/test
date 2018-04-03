import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Phaser;

public class PhaserDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Phaser Demo
		// LongRunningAction.phaserDemo();
		// concurrentMapDemo();
		// countDownDemo();
		// CyclicBarrierRunnable.cyclicBarrierWork();
		executerDemo();
	}

	static void concurrentMapDemo() {
		ConcurrentNavigableMap<String, String> map = new ConcurrentSkipListMap<String, String>();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");

		ConcurrentNavigableMap<String, String> headMap = map.headMap("3");

		headMap.forEach((p, k) -> System.out.println("--" + p + "--Value--" + k));
		System.out.println("=============");

		headMap = map.tailMap("1");

		headMap.forEach((p, k) -> System.out.println("--" + p + "--Value--" + k));
		System.out.println("=============");

		map.put("2", "Amit");
		headMap.forEach((p, k) -> System.out.println("--" + p + "--Value--" + k));
		System.out.println("=============");

		headMap = map.subMap("2", "4");

		headMap.forEach((p, k) -> System.out.println("--" + p + "--Value--" + k));
		System.out.println("=============");
	}

	static void countDownDemo() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);

		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}

	static void executerDemo() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});

		List<Future<String>> result = executorService.invokeAll(callables);

		result.forEach(f -> {
			try {
				System.out.println(f.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		executorService.shutdown();
	}
}

/*****************************************************/
class ExchangerRunnable implements Runnable {

	Exchanger exchanger = null;
	Exchng object = null;
	String tName;

	public ExchangerRunnable(String threadName, Exchanger exchanger, Exchng object) {
		this.exchanger = exchanger;
		this.object = object;
		this.tName = threadName;
	}

	public void run() {
		try {
			Object previous = this.object;

			this.object = (Exchng) this.exchanger.exchange(this.object);

			System.out.println(tName + " exchanged " + previous + " for " + this.object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void exchangeDemo() {
		Exchanger exchanger = new Exchanger();

		ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable("Thread1", exchanger, new Exchng("Amit"));

		ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable("Thread2", exchanger, new Exchng("Semwal"));

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
	}
}

class Exchng {
	String s;

	public Exchng(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return super.toString() + s;
	}
}

/********************************************/
class CyclicBarrierRunnable implements Runnable {

	CyclicBarrier barrier1 = null;
	CyclicBarrier barrier2 = null;

	public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {

		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
			this.barrier1.await();

			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
			this.barrier2.await();

			System.out.println(Thread.currentThread().getName() + " done!");

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	static void cyclicBarrierWork() {
		Runnable barrier1Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 1 executed ");
			}
		};
		Runnable barrier2Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 2 executed ");
			}
		};

		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);

		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);

		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
	}

}

/**************************************************************************/
class Waiter implements Runnable {

	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");
	}
}

class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		try {
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("Latch 1");
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("Latch 2");
			Thread.sleep(1000);
			System.out.println("Latch 3");
			this.latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class LongRunningAction implements Runnable {
	private String threadName;
	private Phaser ph;

	LongRunningAction(String threadName, Phaser ph) {
		this.threadName = threadName;
		this.ph = ph;
		ph.register();
	}

	@Override
	public void run() {
		System.out.println("----" + threadName + "---No of unarrived parties" + ph.getUnarrivedParties());
		ph.arriveAndAwaitAdvance();
		System.out.println("----" + threadName);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ph.arriveAndDeregister();
	}

	static void phaserDemo() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(1);

		// assertEquals(0, ph.getPhase());
		System.out.println("1------" + ph.getPhase());
		executorService.submit(new LongRunningAction("thread-1", ph));
		executorService.submit(new LongRunningAction("thread-2", ph));
		executorService.submit(new LongRunningAction("thread-3", ph));

		ph.arriveAndAwaitAdvance();
		System.out.println("2------" + ph.getPhase());

		// assertEquals(1, ph.getPhase());
	}
}