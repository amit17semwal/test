/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

//import for Scanner and other utility  classes
//import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
    /*    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String lenStr = br.readLine();
        int len = Integer.parseInt(lenStr);*/

        //Scanner
       // Scanner s = new Scanner(System.in);
       // int N = s.nextInt();

   /*     for (int i = 0; i < N; i++) {
             String line1 = br.readLine();
             String line2 = br.readLine();
           System.out.println(getStone(line1,line2,len));
        }*/
        // create a calendar
        Calendar cal = Calendar.getInstance();
     	  
        // print current date
        System.out.println("The current date is : " + cal.getTime());

        // add 20 days to the calendar
        cal.add(Calendar.DATE, 20);
        System.out.println("20 days later: " + cal.getTime());

        // subtract 2 months from the calendar
        cal.add(Calendar.MONTH, -2);
        System.out.println("2 months ago: " + cal.getTime());

        // subtract 5 year from the calendar
        cal.add(Calendar.YEAR, -5);
        System.out.println("5 years ago: " + cal.getTime());
/*
     The current date is : Thu Apr 26 02:13:28 EEST 2012
     20 days later:        Wed May 16 02:13:28 EEST 2012
     2 months ago:         Fri Mar 16 02:13:28 EET  2012
     5 years ago:          Fri Mar 16 02:13:28 EET  2007
*/

      
    }
    static String getStone(String s1, String s2,int len) {
		String st1[] = s1.split(" ");
		String st2[] = s2.split(" ");
		int[]a = new int[len];
		int[]b = new int[len];
		for(int i =0;i<len;i++) {
			a[i]= Integer.parseInt(st1[i]);
			b[i]= Integer.parseInt(st2[i]);
		}
		int count=1, aMax=0,aCount=0,bMax=0,bCount=0;
		for(int i =0; i<a.length;i++){
			int temp = a[i];
			 for(int j = i+1; j<a.length ;j++) {
				 if(temp == a[j])
					 count++;
			 } 
			if(count > aCount) {
				aMax = temp;
				aCount = count;
			}
		}
		count =0;
		for(int i =0; i<b.length;i++){
			int temp = b[i];
			 for(int j = i+1; j<b.length ;j++) {
				 if(temp == b[j])
					 count++;
			 } 
			if( count > bCount) {
				bMax = temp;
				bCount = count;
			}
		}
		
		if(aCount*aMax > bCount*bMax) {
			return "Rupam";
		}else if(aCount*aMax == aCount*aMax) {
			if(aMax > bMax) {
				return "Rupam";	
			}
			else if(aMax == bMax) {
				return "Tie";
			}
		} 
		return "Ankit";
	}
	
    
}
