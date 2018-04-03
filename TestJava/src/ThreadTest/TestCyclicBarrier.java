package ThreadTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.annotation.Native;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Computation1 implements Runnable
{
    public static int product = 0;
    public void run()
    {
        product = 2 * 3;
        try
        {
        	TestCyclicBarrier.newBarrier.await();
        } 
        catch (InterruptedException | BrokenBarrierException e) 
        {
            e.printStackTrace();
        }
    }
}
 
class Computation2 implements Runnable
{
    public static int sum = 0;
    public void run()
    {
        // check if newBarrier is broken or not
        System.out.println("Is the barrier broken? - " + TestCyclicBarrier.newBarrier.isBroken());
        sum = 10 + 20;
        try
        {
        	TestCyclicBarrier.newBarrier.await(3000, TimeUnit.MILLISECONDS);
         
            // number of parties waiting at the barrier
            System.out.println("Number of parties waiting at the barrier "+
            "at this point = " + TestCyclicBarrier.newBarrier.getNumberWaiting());
        } 
        catch (InterruptedException | BrokenBarrierException e) 
        {
            e.printStackTrace();
        } 
        catch (TimeoutException e) 
        {
            e.printStackTrace();
        }
    }
}
 
 
public class TestCyclicBarrier implements Runnable
{
	
	@Native public static final int   MIN_VALUE = 0x80000000;

    /**
     * A constant holding the maximum value an {@code int} can
     * have, 2<sup>31</sup>-1.
     */
    @Native public static final int   MAX_VALUE = 0x7fffffff;
	public static CyclicBarrier newBarrier = new CyclicBarrier(3);
     
    public static void main(String[] args)
    {
      /*  // parent thread
    	TestCyclicBarrier test = new TestCyclicBarrier();
         
        Thread t1 = new Thread(test);
        t1.start();

        Runtime.getRuntime().addShutdownHook(t1);
        System.exit(0);
        System.out.println("Application Terminating ...");*/
        
        
        /*    try
            {
                String[] cmd = new String[2];
                cmd[0] = "java";
                cmd[1] = "abc";
                // create a file with the working directory we wish
                File dir = new File("C:\\Semwal\\StudyDocs\\JAVA");
                // create a process and execute cmdArray
                Process proc = Runtime.getRuntime().exec(cmd, null, dir);
                System.out.println("File.java opening." + proc.toString());
                
                BufferedReader stdInput = new BufferedReader(new 
                	     InputStreamReader(proc.getInputStream()));

                	BufferedReader stdError = new BufferedReader(new 
                	     InputStreamReader(proc.getErrorStream()));
                	
                	// read the output from the command
                	System.out.println("Here is the standard output of the command:\n");
                	String s = null;
                	while ((s = stdInput.readLine()) != null) {
                	    System.out.println(s);
                	}

                	// read any errors from the attempted command
                	System.out.println("Here is the standard error of the command (if any):\n");
                	while ((s = stdError.readLine()) != null) {
                	    System.out.println(s);
                	}
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            */
System.out.println(MIN_VALUE);
System.out.println(MAX_VALUE);
    }
    public void run()
    {
        System.out.println("Number of parties required to trip the barrier = "+
        newBarrier.getParties());
        System.out.println("Sum of product and sum = " + (Computation1.product + 
        Computation2.sum));
         
        // objects on which the child thread has to run
        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();
         
        // creation of child thread
        Thread t1 = new Thread(comp1);
        Thread t2 = new Thread(comp2);
         
        // moving child thread to runnable state
        t1.start();
        t2.start();
 
        try
        {
        	TestCyclicBarrier.newBarrier.await();
        } 
        catch (InterruptedException | BrokenBarrierException e) 
        {
            e.printStackTrace();
        }
         
        // barrier breaks as the number of thread waiting for the barrier
        // at this point = 3
        System.out.println("Sum of product and sum = " + (Computation1.product + 
        Computation2.sum));
                 
        // Resetting the newBarrier
        newBarrier.reset();
        System.out.println("Barrier reset successful");
    }
}



