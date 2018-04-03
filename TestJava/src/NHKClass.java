/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class NHKClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String arr[] = line.split(" ");
        int number2 = Integer.parseInt(arr[1]);
        String rs = "";
          for(int i =0,j=0; i<arr[0].length() ;i++) {
        	  if(arr[0].charAt(i) !='9' && j<number2) {
        		rs+='9';
        		j++;
        	 } else {
        		 rs+=arr[0].charAt(i); 
        	}
        }*/

          /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String n1 = br.readLine();
          int number2 = Integer.parseInt(n1);
          for(int i =0; i<number2 ;i++) {
          	 String num = br.readLine();
          	 int sumEv=0,sumOd=0;
          	 for(int j= 0;j<num.length();j++) {
          	     int n = Integer.parseInt(""+num.charAt(j));
          	     if(n%2==0){
          	         sumEv+=n;
          	     }else{
          	         sumOd+=n;
          	     }
          	 }
          	 if(sumEv>sumOd) {
          	     System.out.println("friendly"); 
          	 }else {
          	   System.out.println(" evil");
          	 }*/
    	int a=10,b=20,c=19,d=30;
    	T2 r1 = new T2(a, b);
    	r1.start();
    	r1.join();
    	T2 r2 = new T2(c, d);
    	r2.start();
    	r2.join();
    	T2 r3 = new T2(r1.sum, r2.sum);
    	r3.start();
    	r3.join();
System.out.println(r3.sum);
    	
  }
      
        
     // find passward from list of string having palindrom string 
       /* for (int i = 0; i < N; i++) {
           strArr[i] = br.readLine();
        }
        int len = 0;
        char ch = 0;
        boolean rs = false;
        for(int j = 0; j<N;j++) {
            len = strArr[j].length()-1;
             rs = false;
             String reverse = "";
             for(int k = len; k>=0;k--) {
            	 reverse +=strArr[j].charAt(k);
             }
             for(int x =j+1; x<N;x++) {
            	 if(x==j) {
            		 continue;
            	 }
            	 if(reverse.equals(strArr[x])) {
            		 rs = true;
            		 int index = strArr[j].length()/2;
            		 ch = strArr[j].charAt(index);
            		 System.out.println((len+1) +" "+ch);
            		 return;
            	 }
             }
        }*/
    }

class T2 extends Thread{
	public volatile int sum = 0;
	int f1,f2;
	T2(int i, int j){
		f1=i;
		f2 =j;
	}

	@Override
	public void run() {
		sum = f1+f2;
		
	}
	
}

