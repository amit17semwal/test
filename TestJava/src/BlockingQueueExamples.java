import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExamples {
	public static void main(String[] args) {
		/*final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
		new Thread(new Producer1(blockingQueue)).start();
		new Thread(new Consumer1(blockingQueue)).start();*/
		
		final BlockingQueue<DelayInt> blockingQueue = new DelayQueue();
		new Thread(new Producer2(blockingQueue)).start();
		new Thread(new Consumer2(blockingQueue)).start();
	}

}

class Producer1 implements Runnable {
	BlockingQueue<Integer> blockingQueue = null;

	public Producer1(BlockingQueue<Integer> blQueue) {
		blockingQueue = blQueue;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<2; i++) {
			Thread.sleep(1000);
			blockingQueue.put(10+i);
			System.out.println("insert"+i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer1 implements Runnable {
	BlockingQueue<Integer> blockingQueue = null;

	public Consumer1(BlockingQueue<Integer> blQueue) {
		blockingQueue = blQueue;
	}

	@Override
	public void run() {
		try {
			for(int i=0; i<2;i++) {
				System.out.println("Retried element " +blockingQueue.take());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer2 implements Runnable {
	BlockingQueue<DelayInt> blockingQueue = null;

	public Producer2(BlockingQueue<DelayInt> blQueue) {
		blockingQueue = blQueue;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<2; i++) {
			Thread.sleep(1000);
			blockingQueue.put(new DelayInt(i*2000));
			System.out.println("insert"+i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer2 implements Runnable {
	BlockingQueue<DelayInt> blockingQueue = null;

	public Consumer2(BlockingQueue<DelayInt> blQueue) {
		blockingQueue = blQueue;
	}

	@Override
	public void run() {
		try {
			for(int i=0; i<2;i++) {
				System.out.println("Retried element " +blockingQueue.take());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class DelayInt implements Delayed {

	int value ;
	public DelayInt(int t) {
		value = t;
	}
	
	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = value - System.currentTimeMillis();
		return diff;
	}
	
}