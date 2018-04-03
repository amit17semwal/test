package dsExcercise;

//Java program to CountKSubStr number of substrings
//with exactly distinct characters in a given string
import java.util.Arrays;

public class CountKSubStr {
	// Function to count number of substrings
	// with exactly k unique characters
	int countkDist(String str, int k) {
		// Initialize result
		int res = 0;

		int n = str.length();

		// To store count of characters from 'a' to 'z'
		int cnt[] = new int[26];

		// Consider all substrings beginning with
		// str[i]
		for (int i = 0; i < n; i++) {
			int dist_count = 0;

			// Initializing count array with 0
			Arrays.fill(cnt, 0);

			// Consider all substrings between str[i..j]
			for (int j = i; j < n; j++) {
				// If this is a new character for this
				// substring, increment dist_count.
				if (cnt[str.charAt(j) - 'a'] == 0)
					dist_count++;

				// Increment count of current character
				cnt[str.charAt(j) - 'a']++;

				// If distinct character count becomes k,
				// then increment result.
				if (dist_count == k)
					res++;
			}
		}

		return res;
	}
	
  char encodedChar(String str, int place) {
	  int st =0;
	  String decrypt="";
	  for(int i =0;i<str.length();i++) {
		  if(Character.getNumericValue(str.charAt(i)) <10 && Character.getNumericValue(str.charAt(i)) > 0) {
			 for(int k=0;k<Character.getNumericValue(str.charAt(i));k++)
			  decrypt+=str.substring(st,i);
			  st = i+1; 
		  }
	  }
	  System.out.println("Decrypted string s " + decrypt);
	  if(st==0)
		  return str.charAt(place);
	  else
		  return decrypt.charAt(place);
  } 
  
	// Driver Program
	public static void main(String[] args) {
		CountKSubStr ob = new CountKSubStr();
		String ch = "aba";
/*		int k = 2;
	//	System.out.println("Total substrings with exactly " + k + " distinct characters : " + ob.countkDist(ch, k));
		
		String str = "ab4c2ed3";
		// "ababababcededed" abababaabccccccc
	    k = 9;
	    System.out.println("Encoded character at " + k +" is :" + ob.encodedChar(str, k));*/
		double i = Math.ceil(1.4);
		System.out.println(i);
		i = Math.floor(1.4);
		System.out.println(i);
		System.out.println((long)(Math.ceil((double)3400 / (double)1000)));
		//assertEquals((long)3, (long)(Math.ceil((double)3400 / (double)1000))); 
		
		System.out.println(Math.floorDiv(2019, 20));
	}
}
