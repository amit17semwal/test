import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestLogic {
	// Total seconds in a day 24*60*60
	private static final int INTERVAL_IN_SECONDS = 86400;
	// Total seconds till 5 AM
	private static final int SECONDS_TILL_FIVE = 18000;
	private static final int SECONDS_IN_MINUTE = 60;
	private static final int SECONDS_IN_HOUR = 3600;
	private static int INT_HIGH_HALF_BIT_MASK = 0xffff0000;
	public static void main(String[] args) {
		/*
		 * // Date date = new Date(); final Calendar calendar =
		 * Calendar.getInstance(); // calendar.setTime(date);
		 * 
		 * int Cons = 60; int hr = calendar.get(Calendar.HOUR_OF_DAY); int min =
		 * calendar.get(Calendar.MINUTE); int sec =
		 * calendar.get(Calendar.SECOND);
		 * 
		 * long totalDelay = (hr*60*60)+(min*60)+sec;
		 * System.out.println("delllllllllllll;;;;;;;;;;;;;" + totalDelay); int
		 * delayInSec = sec < Cons ?Cons - sec : Cons - (sec - Cons);
		 * System.out.println("Current Sec :" + sec + " Delay Hour :" +
		 * delayInSec); System.out.println("Current Time " +
		 * System.currentTimeMillis()); System.out.println("miliseconds---->:" +
		 * calendar.get(Calendar.MILLISECOND)); ScheduledExecutorService
		 * scheduler = Executors.newScheduledThreadPool(1);
		 * 
		 * scheduler.scheduleWithFixedDelay(new Runnable() { //
		 * scheduler.scheduleAtFixedRate(new Runnable() {
		 * 
		 * @Override public void run() { try { Thread.sleep(4000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println("Run Sec Current Sec " +
		 * calendar.get(Calendar.SECOND)); System.out.println("Run at " +
		 * System.currentTimeMillis()); } }, delayInSec, Cons,
		 * TimeUnit.SECONDS); System.out.println(delayInSec);
		 */
		long i = 2000l - 3000l;
		System.out.println("+++++" + i);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmssS");
		String date = "20161213T191212000";
		try {

			Date date1 = dateFormat.parse(date);
			System.out.println(date1.getTime() + "--Hr--" + date1.getHours() + "--min--" + date1.getMinutes()
					+ "--sec--" + date1.getSeconds());
			System.out.println(date1);
			long n = 1482819934449l;
			Date d2 = new Date(n);
			System.out.println(d2.getTime() + "--Hr--" + d2.getHours() + "--min--" + d2.getMinutes() + "--sec--"
					+ d2.getSeconds());
			System.out.println(d2);
			System.out.println(d2.getTimezoneOffset());
			long a = 1000;
			long b = 500;
			long c = a - b;
			Calendar calendar = Calendar.getInstance();
			long currentSeconds = calendar.get(Calendar.HOUR_OF_DAY) * SECONDS_IN_HOUR
					+ calendar.get(Calendar.MINUTE) * SECONDS_IN_MINUTE + calendar.get(Calendar.SECOND);
			long delayTillFive = SECONDS_TILL_FIVE - currentSeconds;
			long delayInSeconds = delayTillFive >= 0 ? delayTillFive : INTERVAL_IN_SECONDS + delayTillFive;
			System.out.println(INT_HIGH_HALF_BIT_MASK);
			List<String> ls = new ArrayList<>();
			ls.add("a");
			ls.add("b");
			ls.add("c");
			ls.add("d");
			for(String s : ls.subList(1, 4)) {
				System.out.println(s);
			}

			// System.out.println(c);
			// System.out.println(c);
			/*
			 * Calendar calendar = Calendar.getInstance(); long currentSeconds =
			 * calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 +
			 * calendar.get(Calendar.MINUTE) * 60 +
			 * calendar.get(Calendar.SECOND);
			 * System.out.println(currentSeconds); System.out.println("Hour" +
			 * calendar.get(Calendar.HOUR_OF_DAY) + "--Minuts" +
			 * calendar.get(Calendar.MINUTE) + "--secods" +
			 * calendar.get(Calendar.SECOND));
			 * System.out.println((System.currentTimeMillis() / 1000));
			 * System.out.println((System.currentTimeMillis() / 1000) % (24 * 60
			 * * 60));
			 */
			// return expectedPattern.format(date);
			/*
			 * long i =1; int j=1; System.out.println(Integer.MAX_VALUE);
			 * System.out.println(Long.MAX_VALUE);
			 * System.out.println(Integer.SIZE); System.out.println(Long.SIZE);
			 */

			/*
			 * System.currentTimeMillis();
			 * dateFormat.parse(""+System.currentTimeMillis());
			 */
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
	}

	public static void set(List<String> lst) {
		lst.add("m");
	}

	public static void setLong(Long a) {

	}

}
class MonitorObject{
	
}
 class MyWaitNotify2{

	  MonitorObject myMonitorObject = new MonitorObject();
	  boolean wasSignalled = false;

	  public void doWait(){
	    synchronized(myMonitorObject){
	      if(!wasSignalled){
	        try{
	          myMonitorObject.wait();
	         } catch(InterruptedException e){}
	      }
	      //clear signal and continue running.
	      wasSignalled = false;
	    }
	  }

	  public void doNotify(){
	    synchronized(myMonitorObject){
	      wasSignalled = true;
	      myMonitorObject.notify();
	    }
	  }
	}