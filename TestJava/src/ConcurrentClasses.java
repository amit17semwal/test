
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 */
public class ConcurrentClasses {

	public static void main(String[] args) {
		concurrentNavigableDemo();
		//blockingQueueDemo();
		//arrayBlockingQueueDemo();
	}
	public static void blockingQueueDemo(){
		//Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        System.out.println("Producer and Consumer has been started");
	}

	public static void arrayBlockingQueueDemo(){
		System.out.println("Hello");
		BlockingQueue queue = new ArrayBlockingQueue(2);

		try {
			queue.put("1");
			queue.put("2");
			queue.put("3");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Object object = queue.take();
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * concurrentNavigableDemo  example
	 */
	public static void concurrentNavigableDemo() {

		System.out.println("Example of ConcurrentNavigableMap:\n");

		ConcurrentNavigableMap navmap = new ConcurrentSkipListMap();
		navmap.put(2, "Monday");
		navmap.put(1, "Sunday");
		
		navmap.put(3, "Tuesday");
		navmap.put(4, "Wednesday");
		navmap.put(5, "Thursday");
		navmap.put(6, "Friday");
		navmap.put(7, "Saturday");
		
		System.out.println("1. descendingKeySet(): " + navmap.descendingKeySet() + "\n");
		System.out.println("2. descendingMap(): " + navmap.descendingMap() + "\n");
		System.out.println("3. headMap(K toKey): " + navmap.headMap(3) + "\n");
		System.out.println("4. headMap(K toKey, boolean inclusive): " + navmap.headMap(3, true) + "\n");
		System.out.println("5. keySet(): " + navmap.keySet() + "\n");
		System.out.println("6. navigableKeySet(): " + navmap.navigableKeySet() + "\n");
		System.out.println("7. subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive): "
				+ navmap.subMap(3, true, 6, true) + "\n");
		System.out.println("8. subMap(K fromKey, K toKey): " + navmap.subMap(3, 6) + "\n");
		System.out.println("9. tailMap(K fromKey): " + navmap.tailMap(3) + "\n");
		System.out.println("10. tailMap(K fromKey, boolean inclusive): " + navmap.tailMap(3, true) + "\n");

	}

}

class Message {
    private String msg;
    
    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

}

class Producer implements Runnable {

    private BlockingQueue<Message> queue;
    
    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<100; i++){
            Message msg = new Message(""+i);
            try {
              //  Thread.sleep(2000);
                queue.put(msg);
               // queue.peek();
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class Consumer implements Runnable{

private BlockingQueue<Message> queue;
   
   public Consumer(BlockingQueue<Message> q){
       this.queue=q;
   }

   @Override
   public void run() {
       try{
           Message msg;
           //consuming messages until exit message is received
           while((msg = queue.take()).getMsg() !="exit"){
        //   Thread.sleep(10);
           System.out.println("Consumed "+Thread.currentThread().getName() +" --:"+msg.getMsg());
           }
       }catch(InterruptedException e) {
           e.printStackTrace();
       }
   }
}
