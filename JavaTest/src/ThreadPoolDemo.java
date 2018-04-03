import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	public static void main(String[] args) {/*
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		System.out.println("The time is : " + new Date());

		ScheduledFuture<?> result = executor.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Schedule iteration" + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, 1, 1, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);	
		executor.submit(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Submitted iteration" + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread.sleep(1000 *60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		executor.shutdown();
	*/
		Map<String, String> s = new HashMap<>();
		s.put(null,"Amit");
		s.put(null,"Semwal");
		System.out.println(s);
		//System.out.println(getWall("BWWWBWBWW") );       
    }
	
	
/*static String swapChar(String str) {
	
	for(int i=0;i<str.length();i++) {
		
		for(int k = i,j=i+1;k<str.length();k=k+2,j =j+2) {
			char tmp = str.charAt(k);
		//	str.replace(oldChar, newChar)
		}
	}
}*/
  static int getWall(String str) {
		int count = 0,count1=0, noOfWall = 0;
		boolean ok = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'W' && count1 < 2 && !ok) {
				count1++;noOfWall++;
			} else if (str.charAt(i) == 'B') {
				ok = true;
				count=0;
				count1 = 0;
				
			}else if (ok && str.charAt(i) == 'W' && count < 2) {
				count++;noOfWall++;
				if (count == 2) {
					ok = false;
					count = 0;
				}
			}
		}
		if(!ok) {
			noOfWall=	noOfWall -count1;
		}
		return noOfWall;
	}
	
	
}