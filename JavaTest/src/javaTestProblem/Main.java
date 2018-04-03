package javaTestProblem;

/*
class Test {
 protected int x, y;
}

class Main {
 public static void main(String args[]) {
     Test t = new Test();
     System.out.println(t.x + " " + t.y);
 }
}

 * Problem 2
 * *********************

class Main2 {
    public static void main(String args[]) {   
        System.out.println(fun());
    } 
    int fun() {
        return 20;
    } 
}

****************Problem3*************
*************************************

class Dummy
{
    public static void main(String args[])
    {
        try
        {
            System.out.println("First statement of try block");
            int num=45/3;
            System.out.println(num);
        }
        catch(Exception e)
        {
            System.out.println("Dummy caught Exception");
        }
        finally
        {
            System.out.println("finally block");
        }
        System.out.println("Main method");
    }
}



************** problem 4 ***************
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
    	Main t = new Main();
             
        // making t eligible for garbage collection
        t = null; 
             
        // calling garbage collector
        System.gc(); 
             
        // waiting for gc to complete
        Thread.sleep(1000); 
     
        System.out.println("end main");
    }
 
    @Override
    protected void finalize() 
    {
        System.out.println("finalize method called");
        System.out.println(10/0);
    }
     
}

******************************Problem 5****************
 
class Base {
    public void Print() {
        System.out.println("Base");
    }         
}
 
class Derived extends Base {    
    public void Print() {
        System.out.println("Derived");
    }
}
 
class Main{
    public static void DoPrint( Base o ) {
        o.Print();   
    }
    public static void main(String[] args) {
        Base x = new Base();
        Base y = new Derived();
        Derived z = new Derived();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z);
    }
}



*/

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
    	long l = 6147483645l;
    	
    	try {
    		int i = (int) l;
    		System.out.println(i);
    	System.out.println(Integer.MAX_VALUE);
    	System.out.println(Long.MAX_VALUE);
    	}
    	catch (Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	
    	/*Main t = new Main();
             
        // making t eligible for garbage collection
        t = null; 
             
        // calling garbage collector
        System.gc(); 
             
        // waiting for gc to complete   
        Thread.sleep(1000); 
     
        System.out.println("end main");*/
    }
 
    @Override
    protected void finalize() 
    {
        System.out.println("finalize method called");
        try {
        System.out.println(10/0);
        }catch (Exception e) {
        	System.out.println("Heeloo exp");
        }
    }
     
}